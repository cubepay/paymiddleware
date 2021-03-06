package com.cubepayment.pmw.data.entity;


public enum TransactionType {

    AUTHORIZATION,
    SALE;

    public static TransactionType getTransactionType(String name) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType.name().equals(name)) {
                return transactionType;
            }
        }
        return null;
    }
}
