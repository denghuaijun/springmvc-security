package com.dhj.security.session.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
//此类相当于springwvc中的applicationContext。xml,类似于在web。xml中的spring上下文加载
@Configuration
@ComponentScan(basePackages = "com.dhj.security.session",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)}
)
public class SpringApplicationConfig {
    //扫面springmvc包下面的所有bean,但是要排除加上controller注解的类，主要用于加载数据库配置，连接池及业务bean的实例化配置扫描
}
