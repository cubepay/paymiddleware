package com.cubepayment.pmw.service;


import com.cubepayment.pmw.data.dao.MerchantDao;
import com.cubepayment.pmw.data.entity.MerchantConfigurationEntity;
import com.cubepayment.pmw.data.entity.MerchantEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(value = "transactionManager")
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private MerchantDao merchantDao;

    @Override
    public MerchantConfigurationEntity getMerchantConfigEntity(Long merchantId) {
        MerchantEntity merchantEntity = merchantDao.findOne(merchantId);
        return merchantEntity.getMerchantConfigurationEntity();
    }

    @Override
    public MerchantEntity getMerchantEntity(Long merchantId) {
        return merchantDao.findOne(merchantId);
    }
}
