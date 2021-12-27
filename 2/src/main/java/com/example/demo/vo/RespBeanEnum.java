package com.example.demo.vo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public enum RespBeanEnum {

    //通用状态码
    SUCCESS(200, "success"),
    ERROR(500, "服务端异常"),
    //登录模块5002xx
    SESSION_ERROR(500210, "session不存在或者已经失效"),
    LOGINVO_ERROR(500211, "用户名或者密码错误"),
    MOBILE_ERROR(500212, "手机号码格式错误"),
    PHONE_ERROR(500213,"手机号重复"),
    NAME_ERROR(500214,"用户名重复"),
    EMAIL_ERROR(500214,"邮箱格式错误"),
    BIND_ERROR(500215,"与输入密码"),
    PASSWORD_ERROR(500216,"密码不一致");

    private final Integer code;
    private final String message;
}