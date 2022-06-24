package com.base.example.utils;

/**
 * @description: --通用返回状态码
 * @author：Bing
 * @date：2021/12/2 11:16
 * @version：1.0
 */
public enum ResultCodeEnum {

    SUCCESS(200, ResultMessageEnum.SUCCESS_COMMON.getMessage()),
    FAILED(500, ResultMessageEnum.FAILED_COMMON.getMessage()),
    FAILED_FEIGN(510, ResultMessageEnum.FAILED_COMMON.getMessage()),
    VALIDATE_FAILED(400, ResultMessageEnum.VALIDATE_FAILED_COMMON.getMessage()),
    FORBBIDEN(403, ResultMessageEnum.FORBBIDEN_COMMON.getMessage()),
    USER_ACCOUNT_ERROR(402, ResultMessageEnum.USER_ACCOUNT_ERROR.getMessage()),
    USER_NOT_FOUND(401, ResultMessageEnum.USER_NOT_FOUND.getMessage()),
    GATEWAY_ERROR(522, ResultMessageEnum.GATEWAY_ERROR.getMessage()),
    USER_NULL(4000,"当前用户为空"),
    TOKEN_EXPIRED(40001,"当前token已过期，请重新获取"),
    SERVICE_INSTANCE_NOT_FOUND(523, ResultMessageEnum.SERVICE_INSTANCE_NOT_FOUND.getMessage());
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
