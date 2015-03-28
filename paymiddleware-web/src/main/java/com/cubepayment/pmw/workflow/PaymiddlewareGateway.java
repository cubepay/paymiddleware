package com.cubepayment.pmw.workflow;


import com.cubepayment.pmw.dto.PaymentTransactionDto;
import org.apache.http.HttpResponse;

public interface PaymiddlewareGateway {

    String doCheckoutLogic(PaymentTransactionDto eCommerceTransactionDto);

    HttpResponse process(PaymentTransactionDto paymentTransactionDto);
}
