package com.cubepayment.pmw.channel;


public interface CheckoutChannel {

    String getToken(String merchantId,String merchantPassword);
}
