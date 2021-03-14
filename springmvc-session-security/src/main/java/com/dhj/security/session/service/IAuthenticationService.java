package com.dhj.security.session.service;

import com.dhj.security.session.model.AuthenticationRequest;
import com.dhj.security.session.model.UserEntity;

/**
 * 认证服务
 */
public interface IAuthenticationService {

    public UserEntity auth(AuthenticationRequest request);
}
