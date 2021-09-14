package com.odas.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        // 放行: 判断什么情况下登陆

        // 先放行登陆页面
        if (request.getRequestURI().contains("goLogin")) {
            System.out.println("请求的是登陆页面，放行");
            return true;
        }

        // 登陆请求也需要放行，否则存储session的步骤无法进行
        if (request.getRequestURI().contains("login")) {
            System.out.println("request.getRequestURI() => " + request.getRequestURI());
            System.out.println("请求的是存储登陆信息(session)的步骤，放行");

            return true;
        }

        // 这里我们没有验证密码正确性，只是判断userLoginInfo里有没有东西
        if (session.getAttribute("userLoginInfo") != null) {
            System.out.println("已经登陆，放行");
            return true;
        }

        // 判断什么情况下没有登陆
        // 没有登陆，则跳转到登陆页面
        // WEB-INF路径下的内容客户端是不能访问的，只能通过转发的形式访问，所以此处不能用重定向
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        System.out.println("没有登陆，不放行");
        // 这里写了true因为跳转了也相当于没放行，不过还是应该返回false
        return false;
    }
}
