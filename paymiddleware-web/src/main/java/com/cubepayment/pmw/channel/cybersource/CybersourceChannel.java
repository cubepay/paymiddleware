//package com.cubepayment.pmw.channel.cybersource;
//
//import com.cubepayment.pmw.channel.PaymentChannel;
//import com.cubepayment.pmw.data.entity.CybersourceConfigurationEntity;
//import com.cubepayment.pmw.dto.PaymentTransactionDto;
//import com.cubepayment.pmw.service.MerchantService;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.LaxRedirectStrategy;
//import org.apache.http.message.BasicNameValuePair;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//@Service(value = "cybersourceChannel")
//public class CybersourceChannel implements PaymentChannel {
//
//    @Resource
//    private MerchantService merchantService;
//
//    @Resource
//    private EncryptionUtil encryptionUtil;
//
//    private static final String SIGNED_FIELD_NAMES = "access_key,profile_id,transaction_uuid,signed_field_names,unsigned_field_names,signed_date_time,locale,transaction_type,reference_number,amount,currency";
//
//    private static final String AUTHORIZATION = "authorization";
//
//    @Override
//    public HttpResponse processPayment(PaymentTransactionDto paymentTransactionDto) {
//
//        CybersourceConfigurationEntity cybersourceMerchantConfigurationEntity = merchantService.getCybersourceMerchantConfigEntity(paymentTransactionDto.getMerchantId());
//
//        HttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
//        HttpPost post = new HttpPost("https://secureacceptance.cybersource.com/pay");
//
//        List<NameValuePair> urlParameters = new ArrayList<>();
//
//        Map<String, String> requestParameterMap = buildMapFromParameters(cybersourceMerchantConfigurationEntity, paymentTransactionDto);
//        Iterator<String> keyIterator = requestParameterMap.keySet().iterator();
//        while (keyIterator.hasNext()) {
//            String key = keyIterator.next();
//            urlParameters.add(new BasicNameValuePair(key, requestParameterMap.get(key)));
//        }
//
////        try {
////            urlParameters.add(new BasicNameValuePair("signature", encryptionUtil.sign(requestParameterMap, cybersourceMerchantConfigurationEntity.getSecretKey())));
////        } catch (InvalidKeyException e) {
////            e.printStackTrace();
////        } catch (NoSuchAlgorithmException e) {
////            e.printStackTrace();
////        } catch (UnsupportedEncodingException e) {
////            e.printStackTrace();
////        }
//
//        try {
//            post.setEntity(new UrlEncodedFormEntity(urlParameters));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            HttpResponse response = client.execute(post);
//            System.out.println("Response Code : "
//                    + response.getStatusLine().getStatusCode());
//
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            StringBuffer result = new StringBuffer();
//            String line = "";
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//
//            String resultString = result.toString();
//
//            System.out.println(resultString);
//
//            return response;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//
//    }
//
//    private Map<String, String> buildMapFromParameters(CybersourceConfigurationEntity cybersourceMerchantConfigurationEntity, PaymentTransactionDto paymentTransactionDto) {
//        Map<String, String> parameterMap = new HashMap<>();
//
//        parameterMap.put("access_key", cybersourceMerchantConfigurationEntity.getAccessKey());
//        parameterMap.put("profile_id", cybersourceMerchantConfigurationEntity.getProfileId());
//        parameterMap.put("transaction_uuid", paymentTransactionDto.getTransactionUUID());
//        parameterMap.put("signed_field_names", SIGNED_FIELD_NAMES);
//        parameterMap.put("unsigned_field_names", "");
//        parameterMap.put("signed_date_time", encryptionUtil.getUTCDateTime());
//        parameterMap.put("locale", paymentTransactionDto.getLocale());
//        parameterMap.put("transaction_type", AUTHORIZATION);
//        parameterMap.put("reference_number", paymentTransactionDto.getReferenceNumber());
//        parameterMap.put("amount", paymentTransactionDto.getTransactionAmount().toString());
//        parameterMap.put("currency", paymentTransactionDto.getCurrency());
//
//        return parameterMap;
//    }
//
//    public void setMerchantService(MerchantService merchantService) {
//        this.merchantService = merchantService;
//    }
//
//    public void setEncryptionUtil(EncryptionUtil encryptionUtil) {
//        this.encryptionUtil = encryptionUtil;
//    }
//}
