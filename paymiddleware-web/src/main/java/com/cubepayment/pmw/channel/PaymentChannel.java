package com.cubepayment.pmw.channel;


import com.cubepayment.pmw.dto.PaymentTransactionDto;
import org.apache.http.HttpResponse;

public interface PaymentChannel {

    HttpResponse processPayment(PaymentTransactionDto paymentTransactionDto);
}
