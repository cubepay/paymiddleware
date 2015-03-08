package com.cubepayment.pmw.constant;


public enum ApplicationPropsKey {

    CHECKOUT_URL("checkout_url");


    private String key;

    ApplicationPropsKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
