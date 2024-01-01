package com.example.poem.service;

import com.example.poem.DTO.UserDTO;
import com.example.poem.entity.User;

public interface UserService {

     User loginService(UserDTO userDTO);

     User registerService(UserDTO userDTO);



}
