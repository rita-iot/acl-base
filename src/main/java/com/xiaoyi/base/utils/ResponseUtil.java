package com.xiaoyi.base.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 进行数据返回
 */
public class ResponseUtil {
    /**
     * 重载方法
     * @param response
     * @param result
     */
    public static void out(HttpServletResponse response, Result result) {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        //response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            mapper.writeValue(response.getWriter(), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
