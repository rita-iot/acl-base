package com.xiaoyi.base.config.security.security;

import com.xiaoyi.base.utils.ResponseUtil;
import com.xiaoyi.base.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未授权统一返回处理类
 */
@Component
public class UnauthEntryPoint extends Throwable implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        //  直接返回信息
        ResponseUtil.out(response, Result.fail(400,"The current user token has expired, please log in again"));
    }
}
