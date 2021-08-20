package com.odas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/h1")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("msg", "Hello, SpringMVCAnnotation!");
        // 加了RequestMapping之后这个函数返回的字符串会被视图解析器处理
        // 也就是说返回的字符串就是jsp文件的文件名
        // 也就是说他会将路径拼接成/WEB-INF/jsp/hello.jsp然后找到对应的文件
        return "hello";
    }
}
