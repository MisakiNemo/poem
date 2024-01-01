package com.example.poem.service;

import com.example.poem.DTO.UserDTO;
import com.example.poem.entity.User;
import com.example.poem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginService(UserDTO userDTO) {
        User user = userMapper.selectUserByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if (user == null) {
            return User.builder().id(-1).build();
        }
        return user;
    }

    @Override
    public User registerService(UserDTO userDTO) {
        User user = userMapper.selectUserByUsername(userDTO.getUsername());
        System.out.println(user);
        if (user != null) {
            return User.builder().id(-1).build();
        }
        user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        userMapper.insert(user);
        return user;
    }
}
