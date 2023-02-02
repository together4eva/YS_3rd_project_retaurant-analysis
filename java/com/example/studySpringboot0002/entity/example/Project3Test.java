package com.example.studySpringboot0002.entity.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Project3Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String num;
    private String score;
    private String review;

    public Project3Test(String title, String num, String score, String review){
        this.title = title;
        this.num = num;
        this.score = score;
        this.review = review;
    }

}



