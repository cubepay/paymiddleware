package com.cubepayment.pmw.data.entity;


public enum Currency {
    SGD;

    public static Currency getCurrency(String name) {
        for (Currency currency : Currency.values()) {
            if (currency.name().equals(name)) {
                return currency;
            }
        }
        return null;
    }
}
