package com.dsq.controller;

import com.dsq.bean.UserBean;
import com.dsq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aa on 2019/7/20.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    @ResponseBody
    public String register(UserBean userBean) {
        userService.register(userBean);
        return "sucess";
    }

}
