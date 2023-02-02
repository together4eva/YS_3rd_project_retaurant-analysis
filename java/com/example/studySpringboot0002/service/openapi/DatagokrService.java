package com.example.studySpringboot0002.service.openapi;

import com.example.studySpringboot0002.entity.openapi.Covid19noti;

import java.util.List;

/**
 * data.go.kr 서버에서 받은 json 데이터를 관리하는 class
 */
public interface DatagokrService {

    /**
     * 외교부 코로나 공지사항 출력 메서드
     * @return List<Covid19noti>
     */
    List<Covid19noti> getCovid19noti();
}
