package com.example.studySpringboot0002.controller.financial;

import com.example.studySpringboot0002.entity.financial.FinancialEntity;
import com.example.studySpringboot0002.service.financial.FinancialExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.studySpringboot0002.component.useLocalMethod.useTimeMethod.timeData;


/**
 * 가계부 작성 순서
 * 1. controller 작성 (URL 호출에 맞춰 흐름 설정) : controller/financial/FinancialController
 * 2. entity 작성 (가계부라는 DB table에 저장할 컬럼을 지정) : entity/financial/FinancialEntity
 * 3. repository 작성 (가계부 entity와 mysql과 연동할 JPARepositoy 구현) : repository/financialExample
 * 4. service Interface와 구현 클래스 작성() : service/financial/**
 */
@Controller
public class FinancialController {
    private FinancialExample financialExample;

    @Autowired
    public FinancialController(FinancialExample financialExample) {
        this.financialExample = financialExample;
    }

    /**
     * 
     * @param model financialList : 가계부 테이블의 목록 모두 조회
     * @return
     */
    @GetMapping("financial_index")
    public String financial_index(Model model ) {
        model.addAttribute("financialList", this.financialExample.FindAllFinancialData());
        return "financial/financial_index";
    }
    /**
     * private String return_operand; 지출, 수익 분별 (+,-)
     * private String price; 금액
     * @return
     */
    @PostMapping("financial_index")
    public String financial_index(
            @RequestParam(value = "return_operand", required = false)String return_operand,
            @RequestParam(value = "price", required = false)String price,
            @RequestParam(value = "financial_day", required = false)String financial_day,
            Model model
    ) {
        this.financialExample.saveFinancialData(new FinancialEntity(return_operand, price, financial_day, timeData()));
        //redirect 적용
        return "redirect:/financial_index";
    }
}
