package com.example.jwt3.service;

import com.example.jwt3.entity.QuestionWrapper;
import com.example.jwt3.entity.Quiz;
import com.example.jwt3.entity.Response;
import com.example.jwt3.entity.Test;
import com.example.jwt3.repository.QuestionRepository;
import com.example.jwt3.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TestService
{

    @Autowired
    TestRepository testRepository;

    private final QuestionRepository questionRepository;

    public ResponseEntity<String> createTest(String title,int numOfQuestion)
    {
        List<Quiz> question =questionRepository.findRandomQuestionByQuestion(numOfQuestion);
        Test test = new Test();
        test.setTittle(title);
        test.setQuestions(question);
        testRepository.save(test);
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getTestQuestions(Integer id) {
        Optional<Test> test = testRepository.findById(id);
        List<Quiz> questionsFromDB = test.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Quiz q :questionsFromDB)
        {
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(),q.getQuestion(),q.getQuestionOptionA(),q.getQuestionOptionB(),q.getQuestionOptionC(),q.getQuestionOptionD());
            questionForUser.add(questionWrapper);
        }


        return new ResponseEntity<>(questionForUser, HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Test> test = testRepository.findById(id);
        List<Quiz> questions =  test.get().getQuestions();
        int totalCorrectAnswers = 0,i = 0;

        for (Response response : responses)
        {
            if(response.getResponse().equals(questions.get(i).getQuestionOptionCorrect()))
                totalCorrectAnswers++;


            i++;
        }
        return new ResponseEntity<>(totalCorrectAnswers,HttpStatus.OK);
    }
}
