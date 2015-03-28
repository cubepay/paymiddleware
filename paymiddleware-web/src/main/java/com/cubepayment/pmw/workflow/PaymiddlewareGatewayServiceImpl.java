//package com.cubepayment.pmw.workflow;
//
//import com.cubepayment.pmw.channel.PaymentChannel;
//import com.cubepayment.pmw.dto.PaymentTransactionDto;
//import com.cubepayment.pmw.service.MerchantService;
//import org.apache.http.HttpResponse;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//
//@Service
//@Transactional(value = "transactionManager")
//public class PaymiddlewareGatewayServiceImpl implements PaymiddlewareGateway {
//
//    @Resource
//    private MerchantService merchantService;
//
//    @Resource
//    private CheckoutService checkoutService;
//
//    @Resource(name = "cybersourceChannel")
//    private PaymentChannel paymentChannel;
//
//    @Override
//    public String doCheckoutLogic(PaymentTransactionDto checkoutRequestTransactionDto) {
//
////        //Log checkout request coming
////        eCommerceTransactionService.saveCreateECommerceTransaction(checkoutRequestTransactionDto);
////
////        //get merchant config
////        CybersourceMerchantConfigurationEntity cybersourceMerchantConfigurationEntity = merchantService.getCybersourceMerchantConfigEntity(checkoutRequestTransactionDto.getMerchantId());
////
////        //Get token from checkout channel(cybersource for now)
////        String token = paymentChannel.getToken(cybersourceMerchantConfigurationEntity.getCybersourceMerchantId(), cybersourceMerchantConfigurationEntity.getCybersourcePassword());
////
////        //build checkout url based on token
////        String checkoutUrl = checkoutService.buildCheckoutUrl(checkoutRequestTransactionDto,token);
////
////        return checkoutUrl;
//
//        return null;
//    }
//
//    @Override
//    public HttpResponse process(PaymentTransactionDto paymentTransactionDto) {
//
//
//        return paymentChannel.processPayment(paymentTransactionDto);
//    }
//}
