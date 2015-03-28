package com.cubepayment.pmw.dto;

import com.cubepayment.pmw.data.entity.TransactionStatus;

import java.math.BigDecimal;

public class PaymentTransactionDto implements PaymiddlewareDTO {

    private Long merchantId;

    private String reqProfileId;

    private String reqTransactionUUID;

    private String reqAccessKey;

    private String reqBillToForename;

    private String reqBillToSurname;

    private String reqBillToEmail;

    private String reqBillToAddressCountry;

    private String reqCardNumber;

    private String reqCardExpiryDate;

    private BigDecimal reqAmount;

    private String reqPaymentMethod;

    private String reqTransactionType;

    private String reqCardType;

    private String reqCurrency;

    private String reqReferenceNumber;

    private String reqBillAddressLine1;

    private String reqBillAddressCity;

    private String reqLocale;

    private TransactionStatus transactionStatus;

    private String authAVSCode;

    private String decision;

    private String authCode;

    private String reasonCode;

    private String authAmount;

    private String signedDateTime;

    private String authCVResult;

    private String transactionId;

    private String authTime;

    private String message;

    private String authResponse;

    private String authTransRefNo;

    public String getReqProfileId() {
        return reqProfileId;
    }

    public void setReqProfileId(String reqProfileId) {
        this.reqProfileId = reqProfileId;
    }

    public String getReqTransactionUUID() {
        return reqTransactionUUID;
    }

    public void setReqTransactionUUID(String reqTransactionUUID) {
        this.reqTransactionUUID = reqTransactionUUID;
    }

    public String getReqAccessKey() {
        return reqAccessKey;
    }

    public void setReqAccessKey(String reqAccessKey) {
        this.reqAccessKey = reqAccessKey;
    }

    public String getReqBillToForename() {
        return reqBillToForename;
    }

    public void setReqBillToForename(String reqBillToForename) {
        this.reqBillToForename = reqBillToForename;
    }

    public String getReqBillToSurname() {
        return reqBillToSurname;
    }

    public void setReqBillToSurname(String reqBillToSurname) {
        this.reqBillToSurname = reqBillToSurname;
    }

    public String getReqBillToEmail() {
        return reqBillToEmail;
    }

    public void setReqBillToEmail(String reqBillToEmail) {
        this.reqBillToEmail = reqBillToEmail;
    }

    public String getReqBillToAddressCountry() {
        return reqBillToAddressCountry;
    }

    public void setReqBillToAddressCountry(String reqBillToAddressCountry) {
        this.reqBillToAddressCountry = reqBillToAddressCountry;
    }

    public String getReqCardNumber() {
        return reqCardNumber;
    }

    public void setReqCardNumber(String reqCardNumber) {
        this.reqCardNumber = reqCardNumber;
    }

    public String getReqCardExpiryDate() {
        return reqCardExpiryDate;
    }

    public void setReqCardExpiryDate(String reqCardExpiryDate) {
        this.reqCardExpiryDate = reqCardExpiryDate;
    }

    public BigDecimal getReqAmount() {
        return reqAmount;
    }

    public void setReqAmount(BigDecimal reqAmount) {
        this.reqAmount = reqAmount;
    }

    public String getReqPaymentMethod() {
        return reqPaymentMethod;
    }

    public void setReqPaymentMethod(String reqPaymentMethod) {
        this.reqPaymentMethod = reqPaymentMethod;
    }

    public String getReqTransactionType() {
        return reqTransactionType;
    }

    public void setReqTransactionType(String reqTransactionType) {
        this.reqTransactionType = reqTransactionType;
    }

    public String getReqCardType() {
        return reqCardType;
    }

    public void setReqCardType(String reqCardType) {
        this.reqCardType = reqCardType;
    }

    public String getReqCurrency() {
        return reqCurrency;
    }

    public void setReqCurrency(String reqCurrency) {
        this.reqCurrency = reqCurrency;
    }

    public String getReqReferenceNumber() {
        return reqReferenceNumber;
    }

    public void setReqReferenceNumber(String reqReferenceNumber) {
        this.reqReferenceNumber = reqReferenceNumber;
    }

    public String getReqBillAddressLine1() {
        return reqBillAddressLine1;
    }

    public void setReqBillAddressLine1(String reqBillAddressLine1) {
        this.reqBillAddressLine1 = reqBillAddressLine1;
    }

    public String getReqBillAddressCity() {
        return reqBillAddressCity;
    }

    public void setReqBillAddressCity(String reqBillAddressCity) {
        this.reqBillAddressCity = reqBillAddressCity;
    }

    public String getReqLocale() {
        return reqLocale;
    }

    public void setReqLocale(String reqLocale) {
        this.reqLocale = reqLocale;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getAuthAVSCode() {
        return authAVSCode;
    }

    public void setAuthAVSCode(String authAVSCode) {
        this.authAVSCode = authAVSCode;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getAuthAmount() {
        return authAmount;
    }

    public void setAuthAmount(String authAmount) {
        this.authAmount = authAmount;
    }

    public String getSignedDateTime() {
        return signedDateTime;
    }

    public void setSignedDateTime(String signedDateTime) {
        this.signedDateTime = signedDateTime;
    }

    public String getAuthCVResult() {
        return authCVResult;
    }

    public void setAuthCVResult(String authCVResult) {
        this.authCVResult = authCVResult;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAuthTime() {
        return authTime;
    }

    public void setAuthTime(String authTime) {
        this.authTime = authTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthResponse() {
        return authResponse;
    }

    public void setAuthResponse(String authResponse) {
        this.authResponse = authResponse;
    }

    public String getAuthTransRefNo() {
        return authTransRefNo;
    }

    public void setAuthTransRefNo(String authTransRefNo) {
        this.authTransRefNo = authTransRefNo;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
