## 基于spring mvc session 做的权限验证知识要点（springmvc-session-security）
1. 使用自定义的登陆类及IAuthenticationService接口进行登陆的认证
2. 登陆的时候将用户信息及权限存储在会话session中传给客户端，再次请求需要加入session来进行请求资源服务
3. 使用拦截器 AuthroziationInteceptor 进行拦截请求，及授权跳转处理

## 基于springmvc整合spring security认证授权知识要点 （springmvc-security-web）
1. 使用springmvc整合security需要添加对应的springsecurity核心配置类SpringSecurityConfig，核心配置类具有以下三个要点
    1.   定义用户登陆信息作为认证使用，主要可以自定义实现useDetailsService接口
    2.   注入bean PasswordEncoding 密码编码器，作为用户认证时密码对比使用
    3.   核心的安全验证拦截器，主要进行权限的控制处理及自定义表单登陆与失败、会话等处理。
2. springsecurity与session模式的区别：
    1.   将使用传统的拦截器来进行用户权限的控制，改成使用springsecurity核心配置类里面的安全验证方法里面进行配置
    2.    登陆认证，传统的session通过表单提交方法来进行逻辑代码判断认证，而springSecurity使用内嵌的AuthenticationManager接口及对应的过滤器内部就已经封装完成。

## spring security与springboot整合实现
1. 认证流程通mvc方式一样
2. 授权模式分类
    1.   web授权，在security核心配置类里面进行配置
    2.   方法授权，需要开启对应的方法授权注解，然后在controller里面的方法上加入对应的注解开启权限。        