package com.example.poem.controller;

import com.example.poem.DTO.UserDTO;
import com.example.poem.entity.User;
import com.example.poem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class userController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public User login(@RequestBody UserDTO userDTO) {
        return userService.loginService(userDTO);
    }


    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.registerService(userDTO);
    }


}
