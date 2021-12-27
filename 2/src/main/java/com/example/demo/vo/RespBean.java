package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;
    /**
     * 成功返回结果
     */
    public static RespBean success() {
        return new RespBean(com.example.demo.vo.RespBeanEnum.SUCCESS.getCode(), com.example.demo.vo.RespBeanEnum.SUCCESS.getMessage(), null);
    }
    /**
     * 成功返回结果
     *
     */
    public static RespBean success(Object obj) {
        return new RespBean(com.example.demo.vo.RespBeanEnum.SUCCESS.getCode(), com.example.demo.vo.RespBeanEnum.SUCCESS.getMessage(), obj);
    }

    /**
     *
     * 失败返回结果
     *
     */

    public static RespBean error(com.example.demo.vo.RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }
}