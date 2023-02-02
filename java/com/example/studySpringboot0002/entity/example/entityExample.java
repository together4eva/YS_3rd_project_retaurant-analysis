package com.example.studySpringboot0002.entity.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class entityExample {

    //Long 타입 : 정수 중에 가장 큰 정수를 담을 수 있는 타입 (ex) 1,2,3,4,5,... Long : 혹시 정수를 어디까지 저장할지 모르겠다 > 가장 큰 거
    // = 정수 뒤에 L : Long 타입 (ex) 300L = Long 타입의 정수 300
    @Id
    private Long id;
    private String name;


}
