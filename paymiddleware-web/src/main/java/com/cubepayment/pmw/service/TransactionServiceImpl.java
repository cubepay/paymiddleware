package com.cubepayment.pmw.service;

import com.cubepayment.pmw.converter.PaymentTransactionDataConverter;
import com.cubepayment.pmw.data.dao.CybersourceTransactionDao;
import com.cubepayment.pmw.data.entity.CybersourceTransactionLogEntity;
import com.cubepayment.pmw.data.entity.QCybersourceTransactionLogEntity;
import com.cubepayment.pmw.data.entity.TransactionStatus;
import com.cubepayment.pmw.dto.PaymentTransactionDto;
import com.mysema.query.BooleanBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private PaymentTransactionDataConverter paymentTransactionDataConverter;

    @Resource
    private CybersourceTransactionDao cybersourceTransactionDao;

    @Override
    public void saveTransactionLog(PaymentTransactionDto paymentTransactionDto) {

        CybersourceTransactionLogEntity cybersourceTransactionLogEntity = cybersourceTransactionDao.findOne(getCybersourceTransactionPredicate(paymentTransactionDto.getReqTransactionUUID()));

        if(cybersourceTransactionLogEntity == null){
            cybersourceTransactionLogEntity = new CybersourceTransactionLogEntity();
            cybersourceTransactionLogEntity.setCreationDate(new Date());
        }

        cybersourceTransactionLogEntity = paymentTransactionDataConverter.convertToEntity(paymentTransactionDto,cybersourceTransactionLogEntity);

        if(cybersourceTransactionLogEntity.getReasonCode()!=null && cybersourceTransactionLogEntity.getAuthResponse().equals("00")){
            cybersourceTransactionLogEntity.setTransactionStatus(TransactionStatus.ACCEPT);
        }
        else{
            cybersourceTransactionLogEntity.setTransactionStatus(TransactionStatus.ERROR);
        }

        cybersourceTransactionLogEntity.setLastUpdateDate(new Date());
        cybersourceTransactionDao.save(cybersourceTransactionLogEntity);

    }

    @Override
    public void saveTransactionLog(CybersourceTransactionLogEntity cybersourceTransactionLogEntity) {
        cybersourceTransactionLogEntity.setLastUpdateDate(new Date());
        cybersourceTransactionDao.save(cybersourceTransactionLogEntity);
    }

    @Override
    public CybersourceTransactionLogEntity getTransactionLogByUUID(String transactionUUID) {
        CybersourceTransactionLogEntity cybersourceTransactionLogEntity = cybersourceTransactionDao.findOne(getCybersourceTransactionPredicate(transactionUUID));

        return cybersourceTransactionLogEntity;
    }

    private BooleanBuilder getCybersourceTransactionPredicate(String transactionUUID){
        QCybersourceTransactionLogEntity qCybersourceTransactionLog = QCybersourceTransactionLogEntity.cybersourceTransactionLogEntity;
        BooleanBuilder booleanCybersourcePredicateBuilder = new BooleanBuilder();

        return booleanCybersourcePredicateBuilder.and(qCybersourceTransactionLog.reqTransactionUUID.eq(transactionUUID));
    }

}
