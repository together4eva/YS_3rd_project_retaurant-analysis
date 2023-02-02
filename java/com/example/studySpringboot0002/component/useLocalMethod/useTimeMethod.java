package com.example.studySpringboot0002.component.useLocalMethod;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component : 어디에서나 접근가능하여 class를 사용할 수 있도록 선언 = @Bean : Container라는 영역에서 대기하는 인스턴스
@Component
public class useTimeMethod {

    public static String timeData() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        String logDate = dateTime.format(formatter);
        return logDate;
    }

}
