package com.cubepayment.pmw.service;


import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;

public interface ECommerceTransactionService {

    /**
     *
     * @param eCommerceTransactionDto
     */
    public void saveCreateECommerceTransaction(CheckoutRequestTransactionDto eCommerceTransactionDto);

}
