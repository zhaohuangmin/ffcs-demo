package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Userservice {
    RespBean login(User user, HttpServletResponse response, HttpServletRequest request);
    RespBean register(User user,HttpServletResponse response, HttpServletRequest request);
    RespBean updatepassword(User user,HttpServletResponse response, HttpServletRequest request);

}
