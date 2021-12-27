package com.example.demo.vo;


import com.example.demo.utils.isMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
    @NotNull
    @isMobile
    private String phone;
    @NotNull
    @Length(min = 32)
    private String password;


}
