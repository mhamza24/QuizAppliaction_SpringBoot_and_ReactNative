package com.example.jwt3.service;

import com.example.jwt3.entity.User;

import java.util.List;

public interface IUserService
{
    User addUser(User user);
    List<User> getUsers();
    User updateUser(User student,int id);

    User getUser(int id);
    void deleteUser(int id);
}
