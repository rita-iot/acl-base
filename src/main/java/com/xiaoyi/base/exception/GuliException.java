package com.xiaoyi.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException extends RuntimeException {
    private Integer code;
    //状态码
    private String msg;
    //异常信息
}
