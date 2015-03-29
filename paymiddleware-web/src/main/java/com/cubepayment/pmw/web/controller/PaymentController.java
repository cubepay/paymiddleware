package com.cubepayment.pmw.web.controller;

import com.cubepayment.pmw.channel.cybersource.EncryptionUtil;
import com.cubepayment.pmw.data.entity.CybersourceConfigurationEntity;
import com.cubepayment.pmw.data.entity.CybersourceTransactionLogEntity;
import com.cubepayment.pmw.data.entity.MerchantEntity;
import com.cubepayment.pmw.data.entity.TransactionStatus;
import com.cubepayment.pmw.dto.PaymentTransactionDto;
import com.cubepayment.pmw.service.MerchantService;
import com.cubepayment.pmw.service.TransactionService;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class PaymentController {

    private final Logger loggerFactory = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private MerchantService merchantService;

    @Resource
    private EncryptionUtil encryptionUtil;

    @Resource
    private TransactionService transactionService;

    private static final String SIGNED_FIELD_NAMES = "access_key,profile_id,transaction_uuid,signed_field_names,unsigned_field_names,signed_date_time,locale,transaction_type,reference_number,amount,currency";


    @RequestMapping(value = "doCheckout", method = {RequestMethod.GET,RequestMethod.POST})
    public String doCheckout(
            @RequestParam Long merchant_id,
            @RequestParam String amount,
            @RequestParam String currency,
            @RequestParam String req_reference_number,
            @RequestParam String locale,
            HttpServletRequest request, Model model) {

        CybersourceConfigurationEntity cybersourceConfigurationEntity = merchantService.getMerchantEntity(merchant_id).getCybersourceConfigurationEntity();
        String transactionType="authorization";

        model.addAttribute("access_key", cybersourceConfigurationEntity.getAccessKey());
        model.addAttribute("profile_id", cybersourceConfigurationEntity.getProfileId());
        model.addAttribute("signed_field_names", SIGNED_FIELD_NAMES);
        model.addAttribute("unsigned_field_names", "");
        model.addAttribute("locale", locale);
        model.addAttribute("transaction_type", transactionType);
        model.addAttribute("reference_number", req_reference_number);
        model.addAttribute("amount", amount);
        model.addAttribute("currency", currency);

        String transactionUUID = UUID.randomUUID().toString();
        String signedDateTime = encryptionUtil.getUTCDateTime();
        model.addAttribute("transaction_uuid", transactionUUID);
        model.addAttribute("signed_date_time", signedDateTime);

        PaymentTransactionDto paymentTransactionDto = buildCheckoutTransactionDTO(merchant_id, req_reference_number, transactionType, currency, amount, signedDateTime, locale);

        paymentTransactionDto.setReqTransactionUUID(transactionUUID);

        Map<String, String> requestParameterMap = buildMapFromParameters(cybersourceConfigurationEntity, paymentTransactionDto);
        requestParameterMap.put("signed_date_time",signedDateTime);

        try {
            String signature = encryptionUtil.sign(requestParameterMap, cybersourceConfigurationEntity.getSecretKey());
            model.addAttribute("signature", signature);

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        model.addAttribute("endpoint_url",cybersourceConfigurationEntity.getEndpointURL());
        //Save Request log
        paymentTransactionDto.setTransactionStatus(TransactionStatus.PENDING);
        transactionService.saveTransactionLog(paymentTransactionDto);

        return "cybersourceFormSubmit";
    }

    @RequestMapping(value = "response", method = RequestMethod.POST)
    public RedirectView saveTransactionResponse(HttpServletRequest request) {

        PaymentTransactionDto paymentTransactionDto = mapResponseToPaymentTransactionDTO(request);

        CybersourceTransactionLogEntity cybersourceTransactionLogEntity = transactionService.getTransactionLogByUUID(paymentTransactionDto.getReqTransactionUUID());
        MerchantEntity merchantEntity = merchantService.getMerchantEntity(cybersourceTransactionLogEntity.getMerchantId());

        paymentTransactionDto.setMerchantId(cybersourceTransactionLogEntity.getMerchantId());
        paymentTransactionDto.setReqCurrency(cybersourceTransactionLogEntity.getReqCurrency());
        paymentTransactionDto.setReqLocale(cybersourceTransactionLogEntity.getReqLocale());
        paymentTransactionDto.setReqProfileId(paymentTransactionDto.getReqProfileId());

        boolean successTransaction=false;
        if(paymentTransactionDto.getAuthResponse().equals("00")){
            successTransaction=true;
        }
        transactionService.saveTransactionLog(paymentTransactionDto);

        StringBuilder sbResponseParameter = new StringBuilder();
        sbResponseParameter.append("success=");
        sbResponseParameter.append(BooleanUtils.toStringTrueFalse(successTransaction));
        sbResponseParameter.append("&reference_no=");
        sbResponseParameter.append(paymentTransactionDto.getReqReferenceNumber());
        if(successTransaction){
            sbResponseParameter.append("&transaction_id=");
            sbResponseParameter.append(cybersourceTransactionLogEntity.getId());
            sbResponseParameter.append("&auth_ref_no=");
            sbResponseParameter.append(paymentTransactionDto.getAuthTransRefNo());
            sbResponseParameter.append("&payment_method=");
            sbResponseParameter.append(paymentTransactionDto.getReqPaymentMethod());
        }
        else{
            sbResponseParameter.append("&error_message=");
            sbResponseParameter.append(paymentTransactionDto.getMessage());
        }

        RedirectView redirectView = new RedirectView(merchantEntity.getMerchantResponseURL()+"?"+sbResponseParameter.toString());

        return redirectView;
    }

    @RequestMapping(value = "cancel_checkout", method = RequestMethod.POST)
    public RedirectView cancelCheckout(HttpServletRequest request) {

        String transactionUUID = request.getParameter("req_transaction_uuid");
        String decision = request.getParameter("decision");
        String message = request.getParameter("message");

        CybersourceTransactionLogEntity cybersourceTransactionLogEntity = transactionService.getTransactionLogByUUID(transactionUUID);
        MerchantEntity merchantEntity = merchantService.getMerchantEntity(cybersourceTransactionLogEntity.getMerchantId());

        Enumeration enParams = request.getParameterNames();
        while(enParams.hasMoreElements()){
            String paramName = (String)enParams.nextElement();
            System.out.println("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
        }

        //Save and update cancel
        cybersourceTransactionLogEntity.setTransactionStatus(TransactionStatus.CANCEL);
        cybersourceTransactionLogEntity.setDecision(decision);
        cybersourceTransactionLogEntity.setMessage(message);
        transactionService.saveTransactionLog(cybersourceTransactionLogEntity);

        StringBuilder sbResponseParameter = new StringBuilder();
        sbResponseParameter.append("cancel=true");
        RedirectView redirectView = new RedirectView(merchantEntity.getMerchantResponseURL()+"?"+sbResponseParameter.toString());

        return redirectView;
    }

    @RequestMapping(value = "checkoutResponseDummy")
    public String responseView(){
        return "checkoutResponseDummy";
    }
    private PaymentTransactionDto mapResponseToPaymentTransactionDTO(HttpServletRequest request) {
        PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto();
        paymentTransactionDto.setReqReferenceNumber(request.getParameter("req_reference_number"));
        paymentTransactionDto.setReqAccessKey(request.getParameter("req_access_key"));
        paymentTransactionDto.setReqTransactionUUID(request.getParameter("req_transaction_uuid"));
        paymentTransactionDto.setReqAccessKey(request.getParameter("req_access_key"));
        paymentTransactionDto.setReqBillToAddressCountry(request.getParameter("req_bill_to_address_country"));
        paymentTransactionDto.setAuthAVSCode(request.getParameter("auth_avs_code"));
        paymentTransactionDto.setReqCardNumber(request.getParameter("req_card_number"));
        paymentTransactionDto.setReqCardExpiryDate(request.getParameter("req_card_expiry_date"));
        paymentTransactionDto.setDecision(request.getParameter("decision"));
        paymentTransactionDto.setReqPaymentMethod(request.getParameter("req_payment_method"));
        paymentTransactionDto.setReqTransactionType(request.getParameter("req_transaction_type"));
        paymentTransactionDto.setAuthCode(request.getParameter("auth_code"));
        paymentTransactionDto.setReqLocale(request.getParameter("en"));
        paymentTransactionDto.setReasonCode(request.getParameter("reason_code"));
        paymentTransactionDto.setReqBillAddressLine1(request.getParameter("req_bill_to_address_line1"));
        paymentTransactionDto.setReqCardType(request.getParameter("req_card_type"));
        paymentTransactionDto.setReqAmount(new BigDecimal(request.getParameter("req_amount")));
        paymentTransactionDto.setAuthAmount(request.getParameter("auth_amount"));
        paymentTransactionDto.setAuthCVResult(request.getParameter("auth_cv_result"));
        paymentTransactionDto.setReqBillAddressCity(request.getParameter("req_bill_to_address_city"));
        paymentTransactionDto.setSignedDateTime(request.getParameter("signed_date_time"));
        paymentTransactionDto.setTransactionId(request.getParameter("transaction_id"));
        paymentTransactionDto.setAuthTime(request.getParameter("auth_time"));
        paymentTransactionDto.setMessage(request.getParameter("message"));
        paymentTransactionDto.setAuthResponse(request.getParameter("auth_response"));
        paymentTransactionDto.setReqProfileId(request.getParameter("req_profile_id"));
        paymentTransactionDto.setAuthTransRefNo(request.getParameter("auth_trans_ref_no"));
        paymentTransactionDto.setReqBillToForename(request.getParameter("req_bill_to_forename"));
        paymentTransactionDto.setReqBillToSurname(request.getParameter("req_bill_to_surname"));
        paymentTransactionDto.setReqBillToEmail(request.getParameter("req_bill_to_email"));

        return paymentTransactionDto;
    }


    private Map<String, String> buildMapFromParameters(CybersourceConfigurationEntity cybersourceMerchantConfigurationEntity, PaymentTransactionDto paymentTransactionDto) {
        Map<String, String> parameterMap = new HashMap<>();

        parameterMap.put("access_key", cybersourceMerchantConfigurationEntity.getAccessKey());
        parameterMap.put("profile_id", cybersourceMerchantConfigurationEntity.getProfileId());
        parameterMap.put("transaction_uuid", paymentTransactionDto.getReqTransactionUUID());
        parameterMap.put("signed_field_names", SIGNED_FIELD_NAMES);
        parameterMap.put("unsigned_field_names", "");
        parameterMap.put("locale", paymentTransactionDto.getReqLocale());
        parameterMap.put("transaction_type", "authorization");
        parameterMap.put("reference_number", paymentTransactionDto.getReqReferenceNumber());
        parameterMap.put("amount", paymentTransactionDto.getReqAmount().toString());
        parameterMap.put("currency", paymentTransactionDto.getReqCurrency());

        return parameterMap;
    }

    private PaymentTransactionDto buildCheckoutTransactionDTO(Long merchantId, String referenceNumber, String transactionType, String currency, String amount, String signedDateTime, String locale) {
        PaymentTransactionDto payRequestDTO = new PaymentTransactionDto();
        payRequestDTO.setMerchantId(merchantId);
        payRequestDTO.setReqTransactionType(transactionType);
        payRequestDTO.setReqCurrency(currency);
        payRequestDTO.setReqAmount(new BigDecimal(amount));
        payRequestDTO.setReqReferenceNumber(referenceNumber);
        payRequestDTO.setReqLocale(locale);
        payRequestDTO.setSignedDateTime(signedDateTime);
        return payRequestDTO;
    }

}
