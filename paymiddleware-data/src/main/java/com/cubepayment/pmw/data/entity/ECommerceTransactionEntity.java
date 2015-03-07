package com.cubepayment.pmw.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ecommerce_transaction")
public class ECommerceTransactionEntity extends BaseEntity{

    private static final long serialVersionUID = -8608171571045466763L;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "line_item_count")
    private int lineItemCount;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currencySupported;

    @Column(name = "transaction_status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name = "auth_response_code")
    private String authResponseCode;

    @Column(name = "auth_response_time")
    private String authResponseTime;

    @Column(name = "auth_ref_no")
    private String authTransRefNo;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public int getLineItemCount() {
        return lineItemCount;
    }

    public void setLineItemCount(int lineItemCount) {
        this.lineItemCount = lineItemCount;
    }

    public Currency getCurrencySupported() {
        return currencySupported;
    }

    public void setCurrencySupported(Currency currencySupported) {
        this.currencySupported = currencySupported;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getAuthResponseCode() {
        return authResponseCode;
    }

    public void setAuthResponseCode(String authResponseCode) {
        this.authResponseCode = authResponseCode;
    }

    public String getAuthResponseTime() {
        return authResponseTime;
    }

    public void setAuthResponseTime(String authResponseTime) {
        this.authResponseTime = authResponseTime;
    }

    public String getAuthTransRefNo() {
        return authTransRefNo;
    }

    public void setAuthTransRefNo(String authTransRefNo) {
        this.authTransRefNo = authTransRefNo;
    }
}
