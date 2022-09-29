package com.xiaoyi.base.config;

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
 * @description: --
 * @author：Bing
 * @date：2022/3/26 21:49
 * @version：1.0
 */
@Component
public class UnauthEntryPointException extends Throwable implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        //  直接返回信息
        ResponseUtil.out(response, Result.fail(400,"The current user token has expired, please log in again"));
    }
}
