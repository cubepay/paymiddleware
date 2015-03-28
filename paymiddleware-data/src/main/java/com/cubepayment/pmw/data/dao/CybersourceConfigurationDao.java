package com.cubepayment.pmw.data.dao;

import com.cubepayment.pmw.data.entity.CybersourceConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CybersourceConfigurationDao extends JpaRepository<CybersourceConfigurationEntity, Long>, QueryDslPredicateExecutor<CybersourceConfigurationEntity> {
}