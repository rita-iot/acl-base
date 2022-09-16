package com.xiaoyi.base.config;

import com.xiaoyi.base.utils.ResponseUtil;
import com.xiaoyi.base.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: --
 * @author：Bing
 * @date：2022/9/16 16:26
 * @version：1.0
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //给前端ResponseResult 的json
        ResponseUtil.out(response, Result.fail(4011,"The current user does not have permission"));
    }
}
