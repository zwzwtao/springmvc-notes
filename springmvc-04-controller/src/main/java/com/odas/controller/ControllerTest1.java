package com.odas.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 只要实现了 controller 接口的类，说明这就是一个控制器了
// 这是一种现在基本不用的方式，但是可以通过他来看原理
// 现在当然都是用注解了
public class ControllerTest1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", "ControllerTest1");
        mv.setViewName("test");

        return mv;
    }
}
