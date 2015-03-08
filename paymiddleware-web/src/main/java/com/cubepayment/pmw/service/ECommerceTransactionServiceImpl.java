package com.cubepayment.pmw.service;

import com.cubepayment.pmw.converter.ECommerceTransactionDataConverter;
import com.cubepayment.pmw.data.dao.EcommerceTransactionDao;
import com.cubepayment.pmw.data.entity.ECommerceTransactionEntity;
import com.cubepayment.pmw.data.entity.TransactionStatus;
import com.cubepayment.pmw.dto.CheckoutRequestTransactionDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional(value = "transactionManager")
public class ECommerceTransactionServiceImpl implements ECommerceTransactionService {

    @Resource
    private EcommerceTransactionDao ecommerceTransactionDao;

    @Resource
    private ECommerceTransactionDataConverter eCommerceTransactionDataConverter;

    @Override
    public void saveCreateECommerceTransaction(CheckoutRequestTransactionDto ecommerceTransactionDto) {
        ECommerceTransactionEntity eCommerceTransactionEntity = eCommerceTransactionDataConverter.convertToEntity(ecommerceTransactionDto);

        //Save specific transaction
        eCommerceTransactionEntity.setTransactionStatus(TransactionStatus.PENDING);
        eCommerceTransactionEntity.setTransactionUID(UUID.randomUUID().toString());
        eCommerceTransactionEntity.setCreationDate(new Date());
        eCommerceTransactionEntity.setLastUpdateDate(new Date());

        ecommerceTransactionDao.save(eCommerceTransactionEntity);
    }
}
