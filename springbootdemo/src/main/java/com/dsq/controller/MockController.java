package com.dsq.controller;

import com.dsq.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.Enumeration;

@Controller
@RequestMapping("/mock")
public class MockController {

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return "get Test";
    }

      @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public String post() {
        return "post Test";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(User user) {
        user.setId(1234L);
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User postUser(@RequestBody User user) {
        user.setId(1234L);
        return user;
    }

    @RequestMapping(value = "/formuser", method = RequestMethod.POST)
    @ResponseBody
    public User postFormUser(@RequestParam String username, User user) {
        // User user = new User();
        user.setId(12345L);
//        user.setUsername(username);
        return user;
    }


}
