package com.example.studySpringboot0002.entity.search;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class searchHistory {

    //@GeneratedValue DB table의 기본키를 자동생성 해주는 어노테이션
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String textHistory;
    private String ipAddress;
    private String updateTime;
    public searchHistory(String textHistory, String ipAddress, String updateTime) {
        this.textHistory = textHistory;
        this.ipAddress = ipAddress;
        this.updateTime = updateTime;
    }
}
