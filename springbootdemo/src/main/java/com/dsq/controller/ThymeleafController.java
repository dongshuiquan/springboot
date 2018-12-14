package com.dsq.controller;

import com.dsq.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 2018/12/6.
 */

@Controller
public class ThymeleafController {

    @RequestMapping("test")
    public String testThymeleaf(Model model) {
        System.out.println(1);
        String text = "World!";
        text = "<b>World</b>";
        model.addAttribute("name", text);

        model.addAttribute("hello", "hello hello");
        model.addAttribute("username", "user");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();

        model.addAttribute("today", new Date());
        model.addAttribute("today2", cal);

        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        model.addAttribute("map", map);

        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("email");
        model.addAttribute("user", user);

        return "test";
    }

    @RequestMapping("hello")
    public String index() {
        return "hello";
    }
}
