package com.example.poem.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.poem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    User selectUserByUsernameAndPassword(String username,String password);


    User selectUserByUsername(String username);


}
