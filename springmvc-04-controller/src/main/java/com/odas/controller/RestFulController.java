package com.odas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    // 如果不用restful风格: http://localhost:8080/add?a=1&b=2
    // RestFul风格: http://localhost:8080/add/a/b
    // @PathVariable注解，让方法参数的值对应绑到一个URI模板变量上
    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    // 之后可以直接使用@GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为: " + res);

        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果2为: " + res);

        return "test";
    }
}
