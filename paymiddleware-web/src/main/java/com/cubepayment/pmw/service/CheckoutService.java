package com.cubepayment.pmw.service;


import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;

public interface CheckoutService {

    /**
     *
     * @param eCommerceTransactionDto
     * @return 3rd party payment url
     */
    String buildCheckoutUrl(CheckoutRequestTransactionDto eCommerceTransactionDto,String token);
}
