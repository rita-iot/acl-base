package com.base.example.utils;

import lombok.Data;

/**
 * @description: --通用返回类
 * @author：Bing
 * @date：2021/12/2 11:18
 * @version：1.0
 */
@Data
public class CommonResult<T> {

    private long code;

    private String message;

    private T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success() {
        return success((T) null);
    }

    /**
     * 成功返回，自定义数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回自定义提示信息
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCodeEnum.FAILED);
    }

    /**
     * 失败返回自定义枚举
     * @param resultCodeEnum
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(ResultCodeEnum resultCodeEnum) {
        return new CommonResult<T>(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), null);
    }

    /**
     * 失败返回自定义提示信息
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回自定义提示信息及返回值
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message, T data) {
        return new CommonResult<T>(ResultCodeEnum.FAILED.getCode(), message, data);
    }

    /**
     * 参数验证失败返回
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCodeEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败自定义提示信息返回
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 参数验证失败自定义返回数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(T data) {
        return new CommonResult<T>(ResultCodeEnum.VALIDATE_FAILED.getCode(), ResultCodeEnum.VALIDATE_FAILED.getMessage(), data);
    }

    /**
     * 定制化提示，给全局异常用
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> custom(Long code, String message) {
        return custom(code, message, null);
    }

    /**
     * 定制化提示，给全局异常用
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> custom(Long code, String message, T data) {
        return new CommonResult<T>(code, message, data);
    }
}
