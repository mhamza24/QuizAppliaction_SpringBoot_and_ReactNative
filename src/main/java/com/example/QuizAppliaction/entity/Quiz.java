package com.example.jwt3.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz
{
    @Id
    @GeneratedValue
    private Long id;
    @NaturalId(mutable = true)
    private String question;
    private String questionOptionA;
    private String questionOptionB;
    private String questionOptionC;
    private String questionOptionD;
    private String questionOptionCorrect;

}
