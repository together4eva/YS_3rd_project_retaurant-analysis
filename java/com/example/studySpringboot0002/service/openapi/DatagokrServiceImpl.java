package com.example.studySpringboot0002.service.openapi;

import com.example.studySpringboot0002.entity.openapi.Covid19noti;
import com.example.studySpringboot0002.repository.openapi.Covid19notiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatagokrServiceImpl implements DatagokrService {



    private final Covid19notiRepository covid19notiRepository;

    //이 클래스를 사용할려면 미리 필드값을 만들어져 있어야하는 어노테이션
    @Autowired
    public DatagokrServiceImpl(Covid19notiRepository covid19notiRepository) {
        this.covid19notiRepository = covid19notiRepository;
    }


    /**
     * 외교부 코로나 공지사항 출력 메서드
     *
     * @return List<Covid19noti>
     */
    @Override
    public List<Covid19noti> getCovid19noti() {
        return covid19notiRepository.findAll();
    }
}
