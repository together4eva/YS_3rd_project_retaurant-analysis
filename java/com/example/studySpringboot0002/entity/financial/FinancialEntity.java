package com.example.studySpringboot0002.entity.financial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * concept : 음수, 양수를 표현하는 entity field 활용 : 평균, 지출내역들 총합 등 다양한 연산수식이 따로 필요하므로 수치와 피연산자를 분리하여 관리
 * 
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinancialEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String return_operand;
    private String price;
    private String financial_day;
    private String update_time;
    
    public FinancialEntity(String return_operand, String price, String financial_day, String update_time) {
        this.return_operand = return_operand;
        this.price = price;
        this.financial_day = financial_day;
        this.update_time = update_time;
    }
}
