package com.example.jwt3.service;

import com.example.jwt3.entity.QuestionWrapper;
import com.example.jwt3.entity.Quiz;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface QuizServiceInterface
{
    Quiz addQuestion(Quiz quiz);
    List<Quiz> getQuestions();
    void deleteQuestion(Long id);
    Quiz update(Quiz quiz,Long id);

}
