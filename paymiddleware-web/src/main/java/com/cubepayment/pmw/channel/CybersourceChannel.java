package com.cubepayment.pmw.channel;

import org.springframework.stereotype.Service;

@Service
public class CybersourceChannel implements CheckoutChannel {

    @Override
    public String getToken(String merchantId, String merchantPassword) {

        //Build request to cybersource to get token based on merchant id and merchant password
        return "DUMMYTOKEN";
    }
}
