package com.example.studySpringboot0002.service.search;

import com.example.studySpringboot0002.entity.search.SearchCSV;
import com.example.studySpringboot0002.entity.search.searchHistory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SearchService {
    /**
     * 검색내용, IP, 시각을 저장하는 메서드
     */
    void saveSearchHistory(searchHistory input);

    /**
     * 검색 내용에 맞춰 데이터 출력 (검색기록)
     * @return List
     */
    List<searchHistory> findAllSearchHistory();

    /**
     * searchSCV 테이블을 모두 조회하여 값을 가져오기
     * @return List배열
     */
    List<SearchCSV> findAllSearchCSVUrl();
}
