package com.odas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // 配置为 RestController, 默认返回json字符串
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }
}
