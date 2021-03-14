package com.dhj.security.session.controller;

import com.dhj.security.session.model.AuthenticationRequest;
import com.dhj.security.session.model.UserEntity;
import com.dhj.security.session.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private IAuthenticationService authenticationService;

    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest request, HttpSession session){
        UserEntity auth = authenticationService.auth(request);
        session.setAttribute("userEntity",auth);
        return auth.getRealname()+"登陆成功";
    }

    @RequestMapping(value = "/res/res1",produces = "text/plain;charset=utf-8")
    public String reqResource1(HttpSession session){
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
        if (userEntity ==null){
            return "匿名访问资源服务1";
        }
        return userEntity.getRealname()+"访问资源服务1";
    }
    @RequestMapping(value = "/res/res2",produces = "text/plain;charset=utf-8")
    public String reqResource2(HttpSession session){
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
        if (userEntity ==null){
            return "匿名访问资源服务2";
        }
        return userEntity.getRealname()+"访问资源服务2";
    }

    @RequestMapping(value = "/loginOut",produces = "text/plain;charset=utf-8")
    public String loginOut(AuthenticationRequest request, HttpSession session){
        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
        if (userEntity !=null){
            //清楚session
            session.invalidate();
            return userEntity.getRealname()+"注销成功";
        }
        return "你还没登陆，请登陆。。。";
    }
}
