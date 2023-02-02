package com.example.studySpringboot0002.service.project3;

import com.example.studySpringboot0002.entity.project3.Project3Entity;
import com.example.studySpringboot0002.repository.project3.Project3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Project3ServiceImpl implements Project3Service {

    private Project3Repository project3Repository;

    @Autowired
    public Project3ServiceImpl(Project3Repository project3Repository) {
        this.project3Repository = project3Repository;
    }
    //모두 조회
    @Override
    public List<Project3Entity> FindAllProject3db() {
        return this.project3Repository.findAll();
    }

    //저장
    @Override
    public void saveProject3db(Project3Entity project3Entity) {
         this.project3Repository.save(project3Entity);
    }

    //전체 저장
    @Override
    public void saveAllProject3db(ArrayList<Project3Entity> project3Entity) {
        this.project3Repository.saveAll(project3Entity);
    }

}
