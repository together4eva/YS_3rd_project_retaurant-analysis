package com.example.studySpringboot0002.component.multi_processing;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiExample2 {

    public static void main(String[] args) {

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.rangeClosed(1, 16)
                // parallel() : 병렬처리 : 특정 작업(반복문 혹은 네트워크 작업 등등)을 CPU 두뇌에게 일임해서 출력하도록 명령
                .parallel()
                .peek(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(i -> System.out.println("i = {}"+ i));
        stopWatch.stop();
        System.out.println(">>> parallel stream takes [{}]ms"+ stopWatch.getTotalTimeMillis());
    }
}