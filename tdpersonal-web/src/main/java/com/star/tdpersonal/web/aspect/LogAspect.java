package com.star.tdpersonal.web.aspect;

import com.alibaba.fastjson.JSONObject;
import com.star.tdpersonal.common.util.common.LoggerNames;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: tdpersonal
 * @description: 出入口统一日志
 * @author: xinsida
 * @create: 2021-06-19 12:22
 **/
@Component
@Aspect
@Slf4j(topic = LoggerNames.CONTROLLER)
@Order
public class LogAspect {

    @Pointcut("execution(public * com.star.tdpersonal.web.controller..*.*(..))")
    public void access() {
    }

    @Around("access()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 获取request信息
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        // 根据request获取session
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        // 从session中取出登录用户信息
        HttpServletRequest request = sra.getRequest();
        // 获取输入参数
        Map<?, ?> inputParamMap = request.getParameterMap();
        // 获取请求地址
        String requestPath = request.getRequestURI();
        log.info("in@{} time = {}, param = {}", requestPath, System.currentTimeMillis(), JSONObject.toJSONString(inputParamMap));
        // 获取返回
        Object result = proceedingJoinPoint.proceed();
        log.info("out@{} time = {}, param = {}, result = {}", requestPath, System.currentTimeMillis(), JSONObject.toJSONString(inputParamMap), result);
        return result;
    }

}
