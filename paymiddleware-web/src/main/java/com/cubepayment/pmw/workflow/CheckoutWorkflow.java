package com.cubepayment.pmw.workflow;


import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;

public interface CheckoutWorkflow {

    public String doCheckoutLogic(CheckoutRequestTransactionDto eCommerceTransactionDto);

}
