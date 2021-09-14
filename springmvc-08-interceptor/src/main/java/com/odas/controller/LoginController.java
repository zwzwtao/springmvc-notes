package com.odas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, Model model) {
        // 把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);

        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session) {
        // 不要使用session.invalidate();这个是销毁session的
        // 因为只要用户浏览器没关session一直都在的，直接销毁session服务器
        // 就又要重新创建session，这样资源消耗会非常大

        // 这里只要移除session里的userLoginInfo即可实现logout
        session.removeAttribute("userLoginInfo");

        return "main";
    }
}
