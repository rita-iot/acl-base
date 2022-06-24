package com.base.example.core.anno;

import java.lang.annotation.*;

/**
 * @description: --自定义注解，加此注解的方法，不需要验证授权。用到controller的方法上
 * @author：Bing
 * @date：2021/12/2 18:05
 * @version：1.0
 */
@Target(ElementType.METHOD)//注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented //生成文档
public @interface UnAuthorized {
    boolean required();
}
