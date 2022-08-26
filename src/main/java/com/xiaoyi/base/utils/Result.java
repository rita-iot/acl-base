package com.xiaoyi.base.utils;

import lombok.Data;

/**
 * 返回对象
 * @param <T>
 */
@Data
public class Result<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    //把构造方法私有
    private Result() {
    }

    /**
     * 异常处理方法
     * @param code
     * @param msg
     * @return
     */
    public static Result exception(Integer code, String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    /**
     * 成功方法
     * @return
     */
    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(20000);
        result.setMessage("成功");
        return result;
    }

    /**
     * 成功方法
     * @param msg
     * @return
     */
    public static Result ok(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(20000);
        result.setMessage(msg);
        return result;
    }

    /**
     * 成功方法
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T t) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(20000);
        result.setMessage("成功");
        result.setData(t);
        return result;
    }

    /**
     * 成功方法
     * @param code
     * @param msg
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(Integer code,String msg,T t) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(msg);
        result.setData(t);
        return result;
    }
    public static Result fail() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(401);
        result.setMessage("失败");
        return result;
    }
    public static Result fail(Integer code,String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
    public static <T> Result<T> fail(Integer code,String msg,T t) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        result.setData(t);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(20001);
        result.setMessage(msg);
        return result;
    }
    public static <T> Result<T> fail(T obj) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(401);
        result.setMessage("失败");
        result.setData(obj);
        return result;
    }
}
