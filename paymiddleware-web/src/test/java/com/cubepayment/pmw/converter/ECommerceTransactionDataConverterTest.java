package com.cubepayment.pmw.converter;

import com.cubepayment.pmw.data.entity.ECommerceTransactionEntity;
import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ECommerceTransactionDataConverterTest {

    private ECommerceTransactionDataConverter eCommerceTransactionDataConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConvertToEntity() throws Exception {
        CheckoutRequestTransactionDto eCommerceTransactionDto = buildECommerceTransactionDTO();
        ECommerceTransactionEntity eCommerceTransactionEntity = eCommerceTransactionDataConverter.convertToEntity(eCommerceTransactionDto);

        assertEquals(eCommerceTransactionEntity.getAmount(), eCommerceTransactionDto.getTransactionAmount());

    }

    private CheckoutRequestTransactionDto buildECommerceTransactionDTO() {
        CheckoutRequestTransactionDto eCommerceTransactionDto = new CheckoutRequestTransactionDto();
        eCommerceTransactionDto.setCurrency("SGD");
        eCommerceTransactionDto.setLineItemCount(20);
        eCommerceTransactionDto.setTransactionAmount(new BigDecimal(200));
        eCommerceTransactionDto.setMerchantId(1L);

        return eCommerceTransactionDto;
    }

    @Test
    public void testConvertToDTO() throws Exception {

    }
}