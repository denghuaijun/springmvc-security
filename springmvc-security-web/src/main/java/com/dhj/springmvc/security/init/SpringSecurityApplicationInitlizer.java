package com.dhj.springmvc.security.init;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 初始化springSecurity容器
 */
public class SpringSecurityApplicationInitlizer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitlizer() {
        super();
    }
}
