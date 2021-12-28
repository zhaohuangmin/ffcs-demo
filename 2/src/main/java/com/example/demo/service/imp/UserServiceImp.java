package com.example.demo.service.imp;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.Exception.GlobalExceptions;
import com.example.demo.Exception.InsertException;
import com.example.demo.Exception.UsernameDuplicateException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.Userservice;
import com.example.demo.utils.CookieUtil;
import com.example.demo.utils.MD5utils;
import com.example.demo.utils.UUIDUtil;
import com.example.demo.utils.ValidatorUtil;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.RespBean;
import com.example.demo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class UserServiceImp implements Userservice {
    @Autowired
    private UserMapper userMapper;


    /**
     * 登入功能
     * @param User
     * @param response
     * @param request
     * @return
     */
    public RespBean login(User User, HttpServletResponse response, HttpServletRequest request) {
        String mobile = User.getPhone();
        String password = User.getPassword();
        String slat = "1a2b3c4d";
        if (StringUtils.isBlank(mobile)|| StringUtils.isBlank(password)){
            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        //根据手机号获取用户
        User user = userMapper.findByUserphone(mobile);
        if (null==user){
            throw new GlobalExceptions(RespBeanEnum.LOGINVO_ERROR);
        }
        //校验密码
        if (!password.equals(user.getPassword())){
            throw new GlobalExceptions(RespBeanEnum.LOGINVO_ERROR);
        }
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();


    }

    /**
     * 注册功能
     * @param user
     * @param response
     * @param request
     * @return
     */
    @Override
    public RespBean register(User user,HttpServletResponse response, HttpServletRequest request) {
        String mobile = user.getPhone();
        String password = user.getPassword();
        String name = user.getUsername();
        String email = user.getEmail();
        String confirmpassword = user.getConfirmpassword();
        User username = userMapper.findByUsername(name);
        String MD5password = MD5utils.InputPassToFromPass(password);
        User phone = userMapper.findByUserphone(mobile);
        if(phone!=null)
        {
            throw new GlobalExceptions(RespBeanEnum.PHONE_ERROR);
        }
        if(!password.equals(confirmpassword)){
            throw new GlobalExceptions(RespBeanEnum.PASSWORD_ERROR);
        }
        if(username!=null){
            throw new GlobalExceptions((RespBeanEnum.NAME_ERROR));
        }
        User register = new User();
        register.setUsername(name);
        register.setPassword(MD5password);
        register.setPhone(mobile);
        register.setEmail(email);
        userMapper.addUser(register);
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,phone);
        CookieUtil.setCookie(request,response,"userTicket",ticket);

        return RespBean.success();

    }

    @Override
    public RespBean updatepassword(User user, HttpServletResponse response, HttpServletRequest request) {
        String newpassword = user.getPassword();
        String mobile = user.getPhone();
        String confirmpassword = user.getConfirmpassword();
        String MD5password = MD5utils.InputPassToFromPass(newpassword);
        User password = userMapper.findByUserPassword(newpassword);
        User phone = userMapper.findByUserphone(mobile);
        if(phone==null)
        {
            throw new GlobalExceptions(RespBeanEnum.PHONE_ERROR);
        }
        if(password!=null){
            throw new GlobalExceptions(RespBeanEnum.UPDATEPASSWORD_ERROR);
        }
        if(!newpassword.equals(confirmpassword)){
            throw new GlobalExceptions(RespBeanEnum.PASSWORD_ERROR);
        }
        userMapper.updatePassword(MD5password, mobile);

        return RespBean.success();
    }
}
