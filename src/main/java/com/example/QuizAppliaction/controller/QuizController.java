package com.example.jwt3.controller;

import com.example.jwt3.entity.QuestionWrapper;
import com.example.jwt3.entity.Quiz;
import com.example.jwt3.entity.Response;
import com.example.jwt3.service.QuizServiceInterface;
import com.example.jwt3.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("exp://192.168.0.131:8081")
@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController
{
    private final QuizServiceInterface quizServiceInterface;

    @Autowired
    TestService testService;
    @GetMapping
    public ResponseEntity<List<Quiz>> getQuestion() {
        return new ResponseEntity<>(quizServiceInterface.getQuestions(), HttpStatus.valueOf(200));
    }

    @PostMapping("/addquestion")
    public Quiz addQuestion(@RequestBody Quiz quiz) {
        return quizServiceInterface.addQuestion(quiz);
    }

    @PostMapping("/createquiz")
    public ResponseEntity<String> createTest(@RequestParam String title,@RequestParam int numOfQuestion) {
        return testService.createTest(title,numOfQuestion);
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getTestQuestion(@PathVariable Integer id)
    {
        return testService.getTestQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
    {
        System.out.println("hi");
        return testService.calculateResult(id,responses);
    }






}
