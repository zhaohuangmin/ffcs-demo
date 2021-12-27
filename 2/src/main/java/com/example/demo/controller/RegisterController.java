package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;
import com.example.demo.utils.JsonUtil;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequestMapping("/add")
@Controller
public class RegisterController {

    @Autowired
    private Userservice userservice;

    @RequestMapping("/submit")
    public String regiser(){
        return "submit";
    }
    @PostMapping("/reg")
    @ResponseBody
    public RespBean register(@Valid User user,HttpServletResponse response, HttpServletRequest request){

        return userservice.register(user,response,request);

    }
}
