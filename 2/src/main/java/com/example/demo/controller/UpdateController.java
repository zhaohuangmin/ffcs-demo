package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;
import com.example.demo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    private Userservice userservice;
    @RequestMapping("/password")
    public String password(){
        return "updatepassword";
    }
    @PostMapping("/new")
    @ResponseBody
    public RespBean register(@Valid User user, HttpServletResponse response, HttpServletRequest request){

        return userservice.updatepassword(user,response,request);

    }

}
