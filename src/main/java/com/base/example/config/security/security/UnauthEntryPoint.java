package com.base.example.config.security.security;

import com.base.example.utils.ResponseUtil;
import com.base.example.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未授权统一返回处理类
 */
public class UnauthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        //  直接返回信息
        ResponseUtil.out(response, Result.fail(50014,"当前用户登录信息已过期，请重新登录"));
    }
}
