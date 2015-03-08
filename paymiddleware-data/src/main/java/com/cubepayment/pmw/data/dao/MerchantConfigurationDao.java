package com.cubepayment.pmw.data.dao;

import com.cubepayment.pmw.data.entity.MerchantConfigurationEntity;
import com.cubepayment.pmw.data.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantConfigurationDao extends JpaRepository<MerchantConfigurationEntity, Long>, QueryDslPredicateExecutor<MerchantConfigurationEntity> {
}