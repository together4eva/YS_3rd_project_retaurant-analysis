package com.example.studySpringboot0002.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Project3Dto {

    private Long id;

    private int number;

    private String title;

    private double numberScore;

    private int numberScoreList;

    private int numberOfReview;

//    private String viewMoreReviewDetail;

    private Integer Analysis;
}
