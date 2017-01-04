package com.example.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.logging.Logger;

/**
 * 防止重复提交拦截器(页面参数名为:token)
 * Created by admin on 2016/8/28.
 */

public class AvoidRepeatSubmissonInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = Logger.getLogger(String.valueOf(AvoidRepeatSubmissonInterceptor.class));


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            AvoidRepeatSubmission annotation = method.getAnnotation(AvoidRepeatSubmission.class);
            if (annotation != null) {
                boolean isSaveSession = annotation.isSaveToken();
                if (isSaveSession) {
                    request.getSession(true).setAttribute("token", Long.toString(new Date().getTime()));
                }
                boolean isRemoveSession = annotation.isRemoveToken();
                if (isRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        LOG.warning("Don't repeat submit this form agin "+request.getServletPath());
                        return false;
                    }
                    request.getSession(false).removeAttribute("token");
                }
            }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
}
