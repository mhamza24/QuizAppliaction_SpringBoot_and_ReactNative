package com.example.jwt3.service;


import com.example.jwt3.entity.QuestionWrapper;
import com.example.jwt3.entity.Quiz;
import com.example.jwt3.entity.Test;
import com.example.jwt3.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService implements QuizServiceInterface
{

    private final QuestionRepository questionRepository;

    @Override
    public List<Quiz> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Quiz addQuestion(Quiz quiz) {
        if(questionRepository.findByQuestion(quiz.getQuestion()).isPresent())
        {
            throw new IllegalStateException("\tThe above question is already exist\n\t"+quiz.getQuestion());
        }
        return questionRepository.save(quiz);

    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public Quiz update(Quiz quiz, Long id) {
        return null;
    }


}
