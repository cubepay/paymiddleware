package com.cubepayment.pmw.service;


import com.cubepayment.pmw.data.entity.MerchantConfigurationEntity;
import com.cubepayment.pmw.data.entity.MerchantEntity;

public interface MerchantService {

    /**
     *
     * @param merchantId
     * @return MerchantConfigurationEntity
     */
    MerchantConfigurationEntity getMerchantConfigEntity(Long merchantId);

    /**
     *
     * @param merchantId
     * @return MerchantEntity
     */
    MerchantEntity getMerchantEntity(Long merchantId);
}
