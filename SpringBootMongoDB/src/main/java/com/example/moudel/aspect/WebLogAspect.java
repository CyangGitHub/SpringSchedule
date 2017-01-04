package com.example.moudel.aspect;


import com.example.moudel.dao.WebLogRepository;
import com.example.moudel.entity.WebLog;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 使用AOP统一处理Web请求日志
 * Created by admin on 2016/11/14.
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(this.getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Autowired
    WebLogRepository webLogRepository;

    @Pointcut("execution(public * com.example.*.controller..*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjd){
        Object result = null;
        //执行目标方法
        startTime.set(System.currentTimeMillis());
        try {
            //前置通知
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());
            logger.info("CLASS_METHOD : " + pjd.getSignature().getDeclaringTypeName() + "." + pjd.getSignature().getName());
            logger.info("ARGS : " + Arrays.toString(pjd.getArgs()));
            result = pjd.proceed();
            WebLog webLog = new WebLog(request.getRequestURL().toString(), Arrays.toString(pjd.getArgs()));
            WebLog save = webLogRepository.save(webLog);
            System.out.println("----------------------------"+save.getUrl());
            System.out.println("----------------------------"+save.getArgs());
            //返回通知
        } catch (Throwable e) {
            //异常通知
            logger.info("EXCEPTION :"+e);
            throw new RuntimeException(e);
        }
        //后置通知
        logger.info("RESULTS : " + result);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        return result;
    }

}
