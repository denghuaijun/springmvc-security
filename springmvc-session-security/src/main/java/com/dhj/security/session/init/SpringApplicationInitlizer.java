package com.dhj.security.session.init;

import com.dhj.security.session.config.SpringApplicationConfig;
import com.dhj.security.session.config.SpringMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 容器初始化启动类入口，同时会加载对应的web.xml SpringApplicationConfig和springmvc.xml SpringMvcConfig
 */
public class SpringApplicationInitlizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringApplicationConfig.class}; //加载spring上下文配置类
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
