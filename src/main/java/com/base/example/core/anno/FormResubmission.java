package com.base.example.core.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: -- 防止表单重复提交
 * @author：Bing
 * @date：2022/2/9 8:47
 * @version：1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormResubmission {
    /**
     * Redis过期时间 默认3s
     * @return
     */
    long expire() default 3;
}
