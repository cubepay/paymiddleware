package com.cubepayment.pmw.data.dao;

import com.cubepayment.pmw.data.entity.CybersourceTransactionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CybersourceTransactionDao extends JpaRepository<CybersourceTransactionLogEntity, Long>, QueryDslPredicateExecutor<CybersourceTransactionLogEntity> {
}
