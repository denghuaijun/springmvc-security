package com.dhj.security.session.service.Impl;

import com.dhj.security.session.model.AuthenticationRequest;
import com.dhj.security.session.model.UserEntity;
import com.dhj.security.session.service.IAuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 此接口主要用于登陆的认证及会话的创建，至于授权管理在拦截器中实现
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    private static Map<String,UserEntity> userEntityMap = new HashMap<>();
    //模拟数据库
    static {

        userEntityMap.put("admin",new UserEntity("admin","123","管理员","男",30, Arrays.asList("pToRes1")));
        userEntityMap.put("admin",new UserEntity("dhj","123","邓怀俊","男",30,Arrays.asList("pToRes2")));
    }
    @Override
    public UserEntity auth(AuthenticationRequest request) {
        //对登陆的用户进行校验
        if (request ==null || !StringUtils.hasLength(request.getUsername())
                || !StringUtils.hasLength(request.getPassword())){
            throw new RuntimeException("用户名、密码不能为空");
        }
        UserEntity userEntity = userEntityMap.get(request.getUsername());
        if (userEntity ==null){
            throw new RuntimeException("用户名为空");
        }
        if (!request.getPassword().equals(userEntity.getPassword())){
            throw new RuntimeException("密码不正确");
        }
        return userEntity;
    }
}
