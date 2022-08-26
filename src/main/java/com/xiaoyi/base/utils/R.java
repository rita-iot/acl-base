package com.xiaoyi.base.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class R<T> {

    private Boolean success;

    private Integer code;

    private String message;

    //private Map<String, Object> data = new HashMap<String, Object>();

    private T data;

    //把构造方法私有
    private R() {
    }

    //成功静态方法
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
    }

    public static <T> R<T> error(T obj) {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        r.setData(obj);
        return r;
    }


    //失败静态方法
    public static R auhtError() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("---认证失败---");
        return r;
    }

    //失败静态方法
    public static R usernameOrPasswordError(String msg) {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage(msg);
        return r;
    }


    //未授权静态方法
    public static R unAuth() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(40001);
        r.setMessage("---未授权方法---");
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        Map<String, Object> data1 = new HashMap<String, Object>();
        data1.put(key, value);
        this.data = (T) data1;
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData((T) map);
        return this;
    }
}
