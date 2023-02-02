package com.example.studySpringboot0002.service.graph;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * barGraph 관련한 연산 메서드 모음집
 */
public interface BarGraphService {

    /**
     * barGraph2 HTML에 전달할 데이터 연산 메서드
     * @return String타입
     */
    String getBarGraph2Data(int wdith);

    ArrayList<String> getLinear_graph_value();

    /**
     * linear 그래프 독립변수 지정하는 메서드
     * @return Arraylist string
     */
    ArrayList<String> getLinear_graph2_x_value();

    /**
     * linear 그래프 종속변수 지정하는 메서드
     * @return Arraylist string
     */
    ArrayList<String> getLinear_graph2_y_value();
}
