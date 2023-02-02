package com.example.studySpringboot0002.controller.project3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class kakaoMapTest {

    @GetMapping("kakaoMap")
    public String kakaoMap() {

        return "kakaoMap/kakaoMap";
    }


}
