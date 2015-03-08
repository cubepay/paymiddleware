package com.cubepayment.pmw.web.controller;

import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;
import com.cubepayment.pmw.workflow.CheckoutWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@Controller
@RequestMapping("/")
public class CheckoutController {

    private final Logger loggerFactory = LoggerFactory.getLogger(CheckoutController.class);

    @Resource
    private CheckoutWorkflow checkoutWorkflowLogic;

    @RequestMapping(value = "doCheckout", method = RequestMethod.GET)
    public RedirectView doCheckout(
                                   @RequestParam Long merchantId,
                                   @RequestParam String transactionType,
                                   @RequestParam String amount,
                                   @RequestParam String deviceType,
                                   @RequestParam int lineItemCount,
                                   @RequestParam String currency,
                                   HttpServletRequest request, HttpServletResponse response) {

        RedirectView redirectView = new RedirectView();

        CheckoutRequestTransactionDto checkoutRequestTransactionDto = buildCheckoutTransactionDTO(merchantId, transactionType,currency, amount, deviceType, lineItemCount);

        String url = checkoutWorkflowLogic.doCheckoutLogic(checkoutRequestTransactionDto);
        redirectView.setUrl(url);
        return redirectView;
    }

    private CheckoutRequestTransactionDto buildCheckoutTransactionDTO(Long merchantId, String transactionType,String currency, String amount, String deviceType, int lineItemCount) {
        CheckoutRequestTransactionDto checkoutRequestTransactionDto = new CheckoutRequestTransactionDto();
        checkoutRequestTransactionDto.setMerchantId(merchantId);
        checkoutRequestTransactionDto.setTransactionType(transactionType);
        checkoutRequestTransactionDto.setDeviceType(deviceType);
        checkoutRequestTransactionDto.setLineItemCount(lineItemCount);
        checkoutRequestTransactionDto.setCurrency(currency);
        checkoutRequestTransactionDto.setTransactionAmount(new BigDecimal(amount));
        return checkoutRequestTransactionDto;
    }

}
