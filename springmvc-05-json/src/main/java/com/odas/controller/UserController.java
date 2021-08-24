package com.odas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.odas.pojo.User;
import com.odas.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
// 虽然使用@ResponseBody可以不让springmvc走视图编辑器
// 不过更加推荐干脆直接把@Controller改为@RestController
// 这样该controller里所有的方法都会返回json字符串
@RestController
public class UserController {

    // 原生解决乱码的方法，在RequestMapping配置一个produces
//    @RequestMapping(value = "/json1", produces = "application/json;charset=utf-8")
    // 但是一般不需要用原生方法，只要统一在springmvc-servlet.xml配置好即可
    @RequestMapping("/json1")
    // 下面语句只要用了@RestController就不需要写了
//    @ResponseBody  // 他就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        // jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 创建一个对象
        User user = new User(1, "Odas一号", 3);

        String str = mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        User user1 = new User(1, "Odas一号", 3);
        User user2 = new User(2, "Odas二号", 4);
        User user3 = new User(3, "Odas三号", 5);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String str = mapper.writeValueAsString(userList);

        return str;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // 使用 ObjectMapper 来格式化输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        Date date = new Date();

        // 时间解析后的默认格式为: Timestamp, 时间戳，所以我们自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1. 通过java的方式把时间转换为字符串
        String strDate = sdf.format(date);
        // 2. 通过jackson自带的方式把日期转换为字符串
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(date);
    }

    // 使用工具类里的getJson
    @RequestMapping("/json4")
    public String json4() {
        Date date = new Date();

        // HH大写是24小时，hh小写是12小时
        return JsonUtils.getJson(date, "yyyy-MM-dd HH:mm:ss");
    }

    // 使用工具类里的getJson
    @RequestMapping("/json5")
    public String json5() {
        Date date = new Date();

        // HH大写是24小时，hh小写是12小时
        return JsonUtils.getJson(date);
    }
}
