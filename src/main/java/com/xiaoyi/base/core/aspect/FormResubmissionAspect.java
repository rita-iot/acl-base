package com.xiaoyi.base.core.aspect;

import cn.hutool.core.util.IdUtil;
import com.xiaoyi.base.core.redis.RedisService;
import com.xiaoyi.base.core.anno.FormResubmission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @description: -- 防止表单重复提交
 * @author：Bing
 * @date：2022/2/9 8:46
 * @version：1.0
 */
@Aspect
@Component
public class FormResubmissionAspect {

    @Autowired
    private RedisService redisService;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.xiaoyi.base.core.anno.FormResubmission)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String methodName = signature.getName();

        FormResubmission formResubmission = method.getAnnotation(FormResubmission.class);
        String redisKey = methodName + "_" + getToken(method);
        //  检查表单是否重复提交
        checkIsFormResubmit(redisKey);
        //  设置表单UUID到Redis
        addFormTagToRedis(formResubmission, redisKey);
        //  执行方法
        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //         方法执行完毕，从Redis中移除设置的表单UUID
        redisService.del(redisKey);
        return proceed;
    }

    private void checkIsFormResubmit(String key) {
        if (redisService.hasKey(key)) {
            //throw new GuliException("请勿重复提交！");
        }
    }

    private void addFormTagToRedis(FormResubmission formResubmission, String redisKey) {
        if (formResubmission != null) {
            redisService.set(redisKey, IdUtil.simpleUUID(), formResubmission.expire());
        }
    }

    private String getToken(Method method) {
        String token = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        token = authentication.getName();
        return token;
    }
}
