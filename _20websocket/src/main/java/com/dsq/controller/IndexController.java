package com.dsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aa on 2019/7/17.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }
}
