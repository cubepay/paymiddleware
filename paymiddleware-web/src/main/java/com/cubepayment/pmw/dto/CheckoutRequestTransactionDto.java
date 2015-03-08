package com.cubepayment.pmw.dto;

import java.math.BigDecimal;

public class CheckoutRequestTransactionDto implements PaymiddlewareDTO {

    private Long merchantId;

    private int lineItemCount;

    private BigDecimal transactionAmount;

    private String currency;

    private String transactionType;

    private String deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public int getLineItemCount() {
        return lineItemCount;
    }

    public void setLineItemCount(int lineItemCount) {
        this.lineItemCount = lineItemCount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
