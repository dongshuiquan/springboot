package com.dsq.controller;

import com.dsq.dao.UserRepository;
import com.dsq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by DELL on 2018/12/5.
 */

@Controller
public class HelloWorldController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/mvc")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/get")
    public String index() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("/getUser")
   // @Cacheable(value="user-key")
    public User getUser() {
        User user=userRepository.findByUsername("bb2");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功...");
        System.out.println(user);
        return user;
    }

    @RequestMapping("/uid")
    @ResponseBody
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
