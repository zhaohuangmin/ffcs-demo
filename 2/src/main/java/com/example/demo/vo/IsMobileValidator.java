package com.example.demo.vo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.utils.ValidatorUtil;
import com.example.demo.utils.isMobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<isMobile,String> {
    private boolean required = false;
    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtil.isMobile(s);
        }
        else {
            if(StringUtils.isBlank(s)){
                return true;
            }
            else {
                return ValidatorUtil.isMobile(s);
            }
        }

    }
}
