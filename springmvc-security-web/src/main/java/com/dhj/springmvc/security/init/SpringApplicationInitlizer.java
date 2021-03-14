package com.dhj.springmvc.security.init;


import com.dhj.springmvc.security.config.SpringApplicationConfig;
import com.dhj.springmvc.security.config.SpringMvcConfig;
import com.dhj.springmvc.security.config.SpringSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * spring容器初始化启动类入口，同时会加载对应的web.xml SpringApplicationConfig和springmvc.xml SpringMvcConfig
 */
public class SpringApplicationInitlizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringApplicationConfig.class, SpringSecurityConfig.class}; //加载spring上下文配置类,将spring security配置类也加入
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};//加载servletContext配置类
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
