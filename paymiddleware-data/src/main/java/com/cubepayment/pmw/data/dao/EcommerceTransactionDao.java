package com.cubepayment.pmw.data.dao;

import com.cubepayment.pmw.data.entity.ECommerceTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceTransactionDao extends JpaRepository<ECommerceTransactionEntity, Long>, QueryDslPredicateExecutor<ECommerceTransactionEntity> {
}
