package com.dhj.security.session.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//登陆用户信息
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserEntity {
    private String username;
    private String password;
    private String realname;
    private String sex;
    private int age;
    //用户对应的权限
    List<String> permissons=new ArrayList<>();

    public UserEntity(String username, String password, String realname, String sex, int age, List<String> permissons) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.permissons = permissons;
    }

    public UserEntity() {
    }

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPermissons() {
        return permissons;
    }

    public void setPermissons(List<String> permissons) {
        this.permissons = permissons;
    }
}
