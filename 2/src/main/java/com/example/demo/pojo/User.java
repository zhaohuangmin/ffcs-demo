package com.example.demo.pojo;

import com.example.demo.enttity.BaseEntity;
import com.example.demo.utils.isMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class User extends BaseEntity {
    private static final long serialVersionUID = -3302907460554699349L;


    private String username;
    @NotNull
    private String password;
    private String salt;
    private Integer gender;
    @NotNull
    @isMobile
    private String phone;
    private String email;
    private String avatar;
    private Integer isDelete;
    private String confirmpassword;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
