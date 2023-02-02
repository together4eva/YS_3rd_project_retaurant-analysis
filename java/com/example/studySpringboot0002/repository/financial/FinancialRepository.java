package com.example.studySpringboot0002.repository.financial;

import com.example.studySpringboot0002.entity.financial.FinancialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<FinancialEntity, Long> {
}
