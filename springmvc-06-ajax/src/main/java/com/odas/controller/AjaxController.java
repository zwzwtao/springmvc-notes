package com.odas.controller;

import com.odas.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController     // 配置为 RestController, 默认返回json字符串
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    // 这里之所以定义的是name而不是前段页面写的username参数名
    // 是因为ajax里定义的data值就是name，而这个name取到了username
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param => " + name);
        if ("odas".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> userList = new ArrayList<User>();

        // 添加数据
        userList.add(new User("odas1", 1, "male"));
        userList.add(new User("odas2", 2, "male"));
        userList.add(new User("odas3", 3, "male"));

        return userList;
    }
}
