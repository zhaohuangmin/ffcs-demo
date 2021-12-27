package com.example.demo;

import com.example.demo.Exception.ServiceException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.imp.UserServiceImp;
import com.example.demo.utils.MD5utils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("project");
        user.setPassword("1234");
        user.setSalt("salt");
        user.setGender(0);
        user.setPhone("13800138002");
        user.setEmail("project@163.com");
        user.setAvatar("avatar");
        user.setIsDelete(0);
        user.setCreatedUser("系统管理员");
        user.setCreatedTime(new Date());
        user.setModifiedUser("超级管理员");
        user.setModifiedTime(new Date());
        //Integer rows = mapper.insert(user);
        //System.err.println("rows=" + rows);
        System.err.println(user);
    }

    @Test
    public void findByUsername() {
        String username = "zhm";
        User result = mapper.findByUsername(username);
        System.err.println(result);
    }
    @Test
    public void findByUserphone() {
        String phone = "15005063113";
        User result = mapper.findByUserphone(phone);
        System.err.println(result);
    }
    @Autowired
    private UserServiceImp service;


//    @Test
//    public void login(){
//        try {
//            String phone = "15005063113";
//            String password = "123456";
//            User result = service.login(phone,password);
//            System.err.println("OK");
//            System.err.println(result);
//
//        }catch (ServiceException e){
//            System.err.println(e.getClass().getName());
//            System.err.println(e.getMessage());
//        }
//    }



}
