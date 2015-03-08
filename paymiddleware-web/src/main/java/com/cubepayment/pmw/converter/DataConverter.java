package com.cubepayment.pmw.converter;

import com.cubepayment.pmw.data.entity.BaseEntity;
import com.cubepayment.pmw.dto.PaymiddlewareDTO;

public interface DataConverter {

    BaseEntity convertToEntity(PaymiddlewareDTO dtoClass);

    PaymiddlewareDTO convertToDTO(BaseEntity entityClass);
}
