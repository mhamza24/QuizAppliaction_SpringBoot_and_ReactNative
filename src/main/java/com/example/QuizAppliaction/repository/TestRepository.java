package com.example.jwt3.repository;

import com.example.jwt3.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Integer>
{

}
