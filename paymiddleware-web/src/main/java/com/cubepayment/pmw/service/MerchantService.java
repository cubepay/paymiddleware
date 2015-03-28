package com.cubepayment.pmw.service;


import com.cubepayment.pmw.data.entity.CybersourceConfigurationEntity;
import com.cubepayment.pmw.data.entity.MerchantEntity;

public interface MerchantService {

    /**
     *
     * @param merchantId
     * @return MerchantConfigurationEntity
     */
    CybersourceConfigurationEntity getCybersourceMerchantConfigEntity(Long merchantId);

    /**
     *
     * @param merchantId
     * @return MerchantEntity
     */
    MerchantEntity getMerchantEntity(Long merchantId);
}
