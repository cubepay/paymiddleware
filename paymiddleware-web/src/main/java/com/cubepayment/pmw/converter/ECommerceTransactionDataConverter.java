package com.cubepayment.pmw.converter;

import com.cubepayment.pmw.data.entity.BaseEntity;
import com.cubepayment.pmw.data.entity.Currency;
import com.cubepayment.pmw.data.entity.DeviceType;
import com.cubepayment.pmw.data.entity.ECommerceTransactionEntity;
import com.cubepayment.pmw.data.entity.TransactionType;
import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;
import com.cubepayment.pmw.dto.PaymiddlewareDTO;
import org.springframework.stereotype.Component;

@Component
public class ECommerceTransactionDataConverter  {

    public ECommerceTransactionEntity convertToEntity(CheckoutRequestTransactionDto eCommerceTransactionDto) {

        ECommerceTransactionEntity eCommerceTransactionEntity = new ECommerceTransactionEntity();
        eCommerceTransactionEntity.setAmount(eCommerceTransactionDto.getTransactionAmount());
        eCommerceTransactionEntity.setCurrencySupported(Currency.getCurrency(eCommerceTransactionDto.getCurrency()));
        eCommerceTransactionEntity.setMerchantId(eCommerceTransactionDto.getMerchantId());
        eCommerceTransactionEntity.setDeviceType(DeviceType.getDeviceType(eCommerceTransactionDto.getDeviceType()));
        eCommerceTransactionEntity.setTransactionType(TransactionType.getTransactionType(eCommerceTransactionDto.getTransactionType()));
        eCommerceTransactionEntity.setQuantity(eCommerceTransactionDto.getLineItemCount());

        return eCommerceTransactionEntity;
    }

    public PaymiddlewareDTO convertToDTO(BaseEntity entityClass) {
        return null;
    }

}
