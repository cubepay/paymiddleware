//package com.cubepayment.pmw.channel.cybersource;
//
//import com.cubepayment.pmw.data.entity.CybersourceConfigurationEntity;
//import com.cubepayment.pmw.dto.PaymentTransactionDto;
//import com.cubepayment.pmw.service.MerchantService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//import static org.mockito.Matchers.anyLong;
//import static org.mockito.Mockito.when;
//
//public class CybersourceChannelTest {
//
//    @Mock
//    private MerchantService merchantService;
//
//    private EncryptionUtil encryptionUtil;
//
//    @InjectMocks
//    private CybersourceChannel cybersourceChannel;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        encryptionUtil = new EncryptionUtil();
//
//        cybersourceChannel.setEncryptionUtil(encryptionUtil);
//    }
//
//    @Test
//    public void testSendAuthorization() throws Exception {
//         when(merchantService.getCybersourceMerchantConfigEntity(anyLong())).thenReturn(buildMerchantConfiguration());
//
//         PaymentTransactionDto paymentTransactionDto = buildPaymentRequestTransactionDTO();
//
//         cybersourceChannel.processPayment(paymentTransactionDto);
//    }
//
//    private CybersourceConfigurationEntity buildMerchantConfiguration() {
//        CybersourceConfigurationEntity cybersourceMerchantConfigurationEntity = new CybersourceConfigurationEntity();
//        cybersourceMerchantConfigurationEntity.setAccessKey("7522a2479e223fa6b3da3a214a29debe");
//        cybersourceMerchantConfigurationEntity.setProfileId("5A696BC0-DB15-4629-985F-3470137987F0");
//        cybersourceMerchantConfigurationEntity.setSecretKey("0bc4a8b1a1f6494eb9424eb550f3f21ad745918c28aa4d8392e6dc3bb6d86a5de181ccdf55ab4a5fab0116c9422a5acaa359375176a84c1ab835ea04a7db0ffafb2a493529ff4246a1527cf7a3c93ab855ebe4cba8b244528b8ced302902a5ff04f6f23768154b0caad32d8283d6c54bb2120e19b0ad4ea683a42a171e8240e0");
//
//
//        return cybersourceMerchantConfigurationEntity;
//    }
//
//    private PaymentTransactionDto buildPaymentRequestTransactionDTO(){
//        PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto();
//        paymentTransactionDto.setTransactionUUID(UUID.randomUUID().toString());
//        paymentTransactionDto.setMerchantId(1L);
//        paymentTransactionDto.setCurrency("SGD");
//        paymentTransactionDto.setTransactionAmount(new BigDecimal(20.00));
//        paymentTransactionDto.setDeviceType("WEB");
//        paymentTransactionDto.setLocale("en");
//        paymentTransactionDto.setReferenceNumber("12345678");
//        paymentTransactionDto.setTransactionType("authorization");
//
//        return paymentTransactionDto;
//    }
//}