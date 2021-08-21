package com.odas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller代表这个类会被Spring接管，被这个注解的类中的所有方法
// 如果返回值是String，并且有具体页面可以跳转，那么就会被视图解析器解析
@Controller
public class ControllerTest2 {

    // 如果类上标注@Controller且方法上没有标注@ResponseBody的话
    // return的值就会被视图解析器处理
    // 这里再谈谈另外一点，如果类上标注的是@RestController的话
    // 或者在方法上标注了@ResponseBody的话，返回值就不会被视图解析器处理

    @RequestMapping("/t2")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerTest2");

        return "test";
    }
}
