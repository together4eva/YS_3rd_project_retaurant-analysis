package com.example.studySpringboot0002.component.multi_processing;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiExample {

    public static void main(String[] args) {
        System.out.println("stream (16 elements) ");
        // StopWatch : 시간을 측정하는 내장 라이브러리
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 람다식 : 함수형 프로그래밍 : 메서드(함수)를 매개변수로 전달하여 실행하는 코드
        // 반복문(for) 객체(절차)지향프로그래밍에서 인자값에 대해 같은 타입으로 return (인풋, 아웃풋 반드시 존재)
        // 함수형 반복문에서는 함수 자체가 반복문 1~16값을 출력하는 함수 (함수 자체가 아웃풋을 출력하는 덩어리)
        IntStream.rangeClosed(1, 16)
                .peek(i -> {
                    // try/catch는 실패할 수 있는 코드 : 병렬처리는 실패가능
                    try {
                        // 1초 쉬기
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(i -> System.out.println("i = {}"+ i));
        stopWatch.stop();
        System.out.println(">>> stream takes [{}]ms"+ stopWatch.getTotalTimeMillis());
    }
}