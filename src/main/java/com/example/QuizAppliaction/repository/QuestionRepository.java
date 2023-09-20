package com.example.jwt3.repository;


import com.example.jwt3.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Quiz,Long>
{
    Optional<Quiz> findByQuestion(String question);

    @Query(value = "select * from Quiz order by RAND()  limit :numofQuestion",nativeQuery = true   )
    List<Quiz> findRandomQuestionByQuestion(int numofQuestion);
}
