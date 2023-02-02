package com.example.studySpringboot0002.service.financial;

import com.example.studySpringboot0002.entity.financial.FinancialEntity;
import com.example.studySpringboot0002.repository.financial.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialExampleImpl implements FinancialExample{

    private FinancialRepository financialRepository;

    @Autowired
    public FinancialExampleImpl(FinancialRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    @Override
    public List<FinancialEntity> FindAllFinancialData() {
        return this.financialRepository.findAll();
    }

    @Override
    public void saveFinancialData(FinancialEntity financialEntity) {
        this.financialRepository.save(financialEntity);
    }

}
