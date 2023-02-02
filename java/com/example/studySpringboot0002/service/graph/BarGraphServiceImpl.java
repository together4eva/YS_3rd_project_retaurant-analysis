package com.example.studySpringboot0002.service.graph;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BarGraphServiceImpl implements BarGraphService {
    /**
     * barGraph2 HTML에 전달할 데이터 연산 메서드
     *
     * @return String타입
     */
    @Override
    public String getBarGraph2Data(int wdith) {
        return "wdith:"+Integer.toString(wdith)+"px";
    }

    @Override
    public ArrayList<String> getLinear_graph_value() {
        ArrayList<String> result = new ArrayList<>() {{
            add("10");
            add("20");
            add("21");
            add("10");
            add("20");
            add("21");
            add("10");
            add("20");
            add("21");
            add("44");
        }};
        return result;
    }

    /**
     * linear 그래프 독립변수 지정하는 메서드
     *
     * @return Arraylist string
     */
    @Override
    public ArrayList<String> getLinear_graph2_x_value() {
        ArrayList<String> result = new ArrayList<>() {{
            add("11");
            add("14");
            add("21");
            add("24");
            add("11");
            add("14");
            add("21");
            add("24");
            add("43");
        }};
        return result;
    }

    /**
     * linear 그래프 종속변수 지정하는 메서드
     *
     * @return Arraylist string
     */
    @Override
    public ArrayList<String> getLinear_graph2_y_value() {
        ArrayList<String> result = new ArrayList<>() {{
            add("21");
            add("54");
            add("31");
            add("14");
            add("51");
            add("34");
            add("11");
            add("63");
            add("13");
        }};
        return result;
    }
}
