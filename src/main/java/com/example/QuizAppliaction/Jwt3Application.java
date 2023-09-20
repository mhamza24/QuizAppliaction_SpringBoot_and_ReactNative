package com.example.jwt3;

import com.example.jwt3.entity.User;
import com.example.jwt3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Jwt3Application {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void inItUser()
    {

        List<User> user = Stream.of
                (
                 new User(1,"Muhammad","Hamza","muhammadhamza@gmail.com"),
                        new User(2,"Hamza","Khan","hamzakhan@gmail.com"),
                        new User(3,"Edward","Kenway","edwardkenway@gmail.com"),
                        new User(4,"Ezio","Aditore","ezioaditore@gmail.com")
                ).collect(Collectors.toList());

        userRepository.saveAll(user);

    }


    public static void main(String[] args) {
        SpringApplication.run(Jwt3Application.class, args);
    }

}
