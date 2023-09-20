package com.example.jwt3.controller;

import com.example.jwt3.entity.AuthRequest;
import com.example.jwt3.entity.User;
import com.example.jwt3.service.IUserService;
import com.example.jwt3.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
@CrossOrigin("exp://192.168.0.131:8081")
@RestController
public class WelcomeController
{

    @Autowired
    private IUserService iUserService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome()
    {
        return "hola form JWT start";
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {

        return iUserService.addUser(user);
    }



    @PostMapping("/authentication")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception
    {
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
            );
        }
        catch (Exception e)
        {
            throw new Exception("invalid Username or password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());

    }


}
