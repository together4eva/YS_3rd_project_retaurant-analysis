package com.example.studySpringboot0002.controller.graph;

import com.example.studySpringboot0002.service.graph.BarGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * 그래프 html 파일 연동하는 controller
 */
@Controller
public class barGraphController {
    //private : 폐쇠적인 : barGraphController 클래스 내부에서만 쓸 수 있는 변수라는 접근제한자
    //final : 상수 : 변수의 값이 변하지 않는다
    //BarGraphService : 타입으로 barGraphController가 활용하는 필드의 클래스타입 선언
    private final BarGraphService barGraphService;

    //@Autowired : 외부에서 주입 받는다 (필요한 데이터나 클래스를 springboot가 관리하는 컨테이너에서 전달 받는다는 어노테이션 속성 선언)
    //public barGraphController : barGraphController의 생성자 : 클래스를 사용할 때 초기값 만들기 : 생성자 주입방식이므로 순서가 명확해짐
    //(BarGraphService barGraphService) : 매개변수로써 container라는 @Bean에서 데이터를 받음
    //@Bean이란 코드에서 필요할 때 즉각적으로 데이터를 전달하기 위해서 항상 대기를 하는 인스턴스들 : DI : Dependency Injection : 의존성 주입 : 의존이 필요한 데이터를 주입
    //DI라는 개념을 Springboot에서 알아서 한다 (개발자가 하지 않는다) : IoC : Inversion of Control : 제어의 역전 : 원래 개발자가 제어해야 하는데 springboot가 제어한다
    @Autowired
    public barGraphController(BarGraphService barGraphService) {
        this.barGraphService = barGraphService;
    }

    /**
     *
     * @return URL Source
     */
    @GetMapping("barGraph1")
    public String barGraph1() {
        return "graph/barGraph1";
    }

    @GetMapping("barGraph3")
    public String barGraph3() {
        return "graph/barGraph3";
    }

    @GetMapping("barGraph4")
    public String barGraph4() {
        return "graph/barGraph4";
    }

    @GetMapping("exampleGraph")
    public String exampleGraph() {
        return "graph/exampleGraph";
    }


    /**
     *
     * @param model
     * @return
     */
    @GetMapping("barGraph")
    public String barGraph2(Model model) {

        model.addAttribute("progress_bar_frame_option", "animation: load50 3s normal forwards");

        model.addAttribute("progress_bar_frame_option_test", "animation: load100 3s normal forwards");

        //model : 장바구니 : HTML에 데이터 전달하는 장바구니 (KEY, VALUE로 되어 있어서, key값을 호출하면 value를 얻을 수 있음)
        //addAttribute() : key, value 값을 넣는 메서드
        model.addAttribute("bargraph2value", barGraphService.getBarGraph2Data(50));
        model.addAttribute("linear_graph_value", barGraphService.getLinear_graph_value());

        //linear graph 2 & 3d graph
        model.addAttribute("linear_trace1_x_value", barGraphService.getLinear_graph2_x_value());
        model.addAttribute("linear_trace1_y_value", barGraphService.getLinear_graph2_y_value());
        model.addAttribute("linear_trace2_x_value", barGraphService.getLinear_graph2_y_value());
        model.addAttribute("linear_trace2_y_value", barGraphService.getLinear_graph2_x_value());

        //mission : @service에서 데이터를 받아서 controller model에 데이터를 넣고,
        // css / javascript 타임리프 문법으로 데이터를 넣어서 그래프를 완성하시오
        //css : <div th:attrappend="style=${data}"></div> : 속성=속성값 모두 문자열로 전달해야 함
        //javascript :
        //    /*<![CDATA[*/
        //        trace1.x = /*[[${xdata1}]]*/
        //    /*]]>*/
        return "index";
    }
}
