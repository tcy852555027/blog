package com.tcy.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */
// 拦截器
public class LoginInterceptor  extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {  //session中没有user 将重定向
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
