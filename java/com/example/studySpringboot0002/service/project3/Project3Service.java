package com.example.studySpringboot0002.service.project3;

import com.example.studySpringboot0002.entity.project3.Project3Entity;


import java.util.ArrayList;
import java.util.List;


public interface Project3Service {

    List<Project3Entity> FindAllProject3db();

    void saveProject3db(Project3Entity project3Entity);

    void saveAllProject3db(ArrayList<Project3Entity> project3Entity);





}
