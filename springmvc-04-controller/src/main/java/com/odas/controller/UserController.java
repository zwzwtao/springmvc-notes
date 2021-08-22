package com.odas.controller;

import com.odas.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    // localhost:8080/user/t1?name=***;
    // 推荐一定加@RequestParam，一个原因是可以给别名，另外一个原因
    // 是可以提醒这是一个前端接的参数
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        // 1. 接收前端
        System.out.println("接收到前端的参数为: " + name);
        // 2. 将返回的结果返回给前端，Model
        model.addAttribute("msg", name);
        // 3. 视图跳转
        return "test";
    }

    // 前端接收的是一个对象: id, name, age

    /**
     * 1. 接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
     * 2. 或者传递的是一个对象，比如这里是User对象，则匹配对象中的字段名即可
     *    以User对象的例子来讲就是?id=***&name=***&age=***
     */
    @GetMapping("/t2")
    public String test2(User user) {
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap map) {
        // ModelMap就是Model的复杂版本，继承了LinkedHashMap的所有功能

        return "test";
    }
}
