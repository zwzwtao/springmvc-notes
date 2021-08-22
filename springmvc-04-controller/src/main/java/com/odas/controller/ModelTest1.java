package com.odas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());

        // 如果没有在springmvc-servlet.xml配置视图解析器的话
        // 就需要在return把url全名打上/WEB-INF/jsp/test.jsp
        // 或者再加一个forward: 比如: forward:/WEB-INF/jsp/test.jsp
        // 也就是说forward是默认就有的
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t2")
    public String test2() {
        return "redirect:/index.jsp";
    }
}
