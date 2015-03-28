package com.cubepayment.pmw.converter;

import com.cubepayment.pmw.data.entity.CybersourceTransactionLogEntity;
import com.cubepayment.pmw.dto.PaymentTransactionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PaymentTransactionDataConverter {

    public CybersourceTransactionLogEntity convertToEntity(PaymentTransactionDto eCommerceTransactionDto, CybersourceTransactionLogEntity cybersourceTransactionLogEntity) {


        BeanUtils.copyProperties(eCommerceTransactionDto,cybersourceTransactionLogEntity);

        cybersourceTransactionLogEntity.setReqAmount(eCommerceTransactionDto.getReqAmount().toString());
        return cybersourceTransactionLogEntity;
    }
}
