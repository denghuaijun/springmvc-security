package com.dhj.security.session.interceptor;

import com.dhj.security.session.consts.Const;
import com.dhj.security.session.model.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 授权拦截器，拦截用户请求，并进行授权
 */
public class AuthroziationInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过认证保存的session来获取对应的用户信息
        HttpSession session = request.getSession();
        UserEntity entity = (UserEntity) session.getAttribute(Const.USER_ENTITY_KEY);
        if (entity ==null){
            write(response,"请先登陆。。。");
        }
        String requestURL = request.getRequestURI();
        if (requestURL.equals("/res/res1") && entity.getPermissons().contains("pToRes1")){
            return true;
        }
        if (requestURL.equals("/res/res2") && entity.getPermissons().contains("pToRes2")){
            return true;
        }
        write(response,"权限不足，拒绝访问！");

        return false;
    }

    public void write(HttpServletResponse response,String message) throws IOException {
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        //这句话是解决乱码的
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.getWriter().write(message);
        response.getWriter().close();
        response.getWriter().flush();
    };
}
