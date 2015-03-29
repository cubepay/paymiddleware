package com.cubepayment.pmw.service;

import com.cubepayment.pmw.data.entity.CybersourceTransactionLogEntity;
import com.cubepayment.pmw.dto.PaymentTransactionDto;


public interface TransactionService  {

    void saveTransactionLog(PaymentTransactionDto paymentTransactionDto);

    void saveTransactionLog(CybersourceTransactionLogEntity cybersourceTransactionLogEntity);

    CybersourceTransactionLogEntity getTransactionLogByUUID(String transactionUUID);
}
