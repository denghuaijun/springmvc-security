package com.dhj.springmvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * spring security 核心配置类
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    //定义存储用户信息，作为登陆认证
    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        //这样是将用户信息村粗在内存中，后续可以自定义UserDetailsService实现类，并将数据库中获取用户信息
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("123").authorities("r1").build());
        manager.createUser(User.withUsername("dhj").password("123").authorities("r2").build());
        return manager;
    }
    //密码编码器，就用户输入的密码进行加密/不加密与内存/数据库中的用户密码对比
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();//实现一个字符串铭文密码编码器
    }
    //安全请求验证授权，相当于session中的拦截器功能

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //注明拥有权限标识p1才能访问res1资源服务
                .antMatchers("/res/res1").hasAuthority("r1")
                //注明拥有权限标识p2才能访问res2资源服务
                .antMatchers("/res/res2").hasAuthority("r2")
                //将以请求路径以/res开头的请求路径都需要通过认证才能访问，
                .antMatchers("/res/**").authenticated()
                //其它的请求放开权限
                .anyRequest().permitAll()
                .and()
                //表单登陆模式
                .formLogin()
                //登陆成功跳转的路径
                .successForwardUrl("/success-form")
                .and()
                .csrf().disable();
    }
}
