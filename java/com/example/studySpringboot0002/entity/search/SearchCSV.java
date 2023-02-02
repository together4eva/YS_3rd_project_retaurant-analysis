package com.example.studySpringboot0002.entity.search;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CSV 파일의 위치 URL 저장 및 출력
 * @field CSV 파일 URL, 업데이트 날짜
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCSV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String csvURL;
    private String subject;
}
