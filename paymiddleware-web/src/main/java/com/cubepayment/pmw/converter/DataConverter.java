package com.cubepayment.pmw.converter;

import com.cubepayment.pmw.data.entity.BaseEntity;
import com.cubepayment.pmw.data.entity.CybersourceTransactionLogEntity;
import com.cubepayment.pmw.dto.PaymiddlewareDTO;

public interface DataConverter {

    CybersourceTransactionLogEntity convertToEntity(PaymiddlewareDTO sourceDTOClass, BaseEntity targetBaseEntity);

}
