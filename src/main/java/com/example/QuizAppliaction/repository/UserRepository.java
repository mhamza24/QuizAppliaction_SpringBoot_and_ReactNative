package com.example.jwt3.repository;

import com.example.jwt3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
    Optional<User> findByEmail(String email);
}
