package com.xiaoyi.base.core.aspect;

import com.xiaoyi.base.system.service.AclLogService;
import com.xiaoyi.base.core.anno.LogAnnotation;
import com.xiaoyi.base.system.entity.AclLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @description: --
 * @author：Bing
 * @date：2022/1/22 14:16
 * @version：1.0
 */
@SuppressWarnings("ALL")
@Aspect
@Component
public class LogAspect {
    @Autowired
    private AclLogService aclLogService;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.xiaoyi.base.core.anno.LogAnnotation)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        //             执行方法
        result = point.proceed();
        //         执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //         保存日志
        saveLog(point, time, "2", null);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time, String type, String exception) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AclLog log = new AclLog();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        if (logAnnotation != null) {
            //  注解上的描述
            log.setTitle(logAnnotation.value());
        }
        //  请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");
        //  请求的方法参数值
        Object[] args = joinPoint.getArgs();

        String requestMethod = request.getMethod();
        log.setRequestType(requestMethod);

        //  请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                params.append("  ").append(paramNames[i]).append(": ").append(args[i]);
            }
            //log.setParams(params.toString());
        }
        //        设置IP地址
        log.setRemoteIp(request.getRemoteAddr());
        //        设置请求uri
        log.setRequestUrl(request.getRequestURI());
        //        操作执行时长
        log.setOpstime(Math.toIntExact(time));
        //        日志类型
        log.setType(type);
        aclLogService.addLog(log);
    }
}
