package com.odas.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 只要继承了HandlerInterceptor就成了一个拦截器
public class MyInterceptor implements HandlerInterceptor {

    // 如果return true 则执行下一个拦截器，放行的意思
    // 如果return false 则不执行下一个拦截器，表示不放行，如果写了false程序就停住啦
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=============== preHandle 处理前 ===============");

        return true;
    }

    // 拦截完毕后的日志一般可以在postHandle里处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("=============== postHandle 处理后 ===============");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("=============== 清理 ===============");
    }
}
