package com.example.jwt3.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
public class QuestionWrapper
{
    private Long id;
    private String question;
    private String questionOptionA;
    private String questionOptionB;
    private String questionOptionC;
    private String questionOptionD;

    public QuestionWrapper(Long id, String question, String questionOptionA, String questionOptionB, String questionOptionC, String questionOptionD) {
        this.id = id;
        this.question = question;
        this.questionOptionA = questionOptionA;
        this.questionOptionB = questionOptionB;
        this.questionOptionC = questionOptionC;
        this.questionOptionD = questionOptionD;
    }
}
