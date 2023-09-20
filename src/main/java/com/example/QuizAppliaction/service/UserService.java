package com.example.jwt3.service;

import com.example.jwt3.entity.User;
import com.example.jwt3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService
{
    private final UserRepository userRepository;

    @Override
    public User addUser(User user)
    {
        User userName = userRepository.findByUserName(user.getUserName());

        if(userRepository.findByEmail(user.getEmail()).isPresent())
        {
            try {
                throw new Exception("This email : "+user.getEmail()+" already exsist,SignUp with new email");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User updateUser(User student, int id) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

}
