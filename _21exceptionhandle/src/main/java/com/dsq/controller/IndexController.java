package com.dsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aa on 2019/7/17.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/index/{number}")
    @ResponseBody
    public String index(@PathVariable int number) {
        System.out.println(20 / number);
        return "get index page successfully.";
    }

    @RequestMapping(value = "/error/{number}")
    @ResponseBody
    public String error(@PathVariable String number) throws Exception {
        if("400".equals(number)) {
            throw new Exception("exception");
        } else if("500".equals(number)) {
            throw new Exception("500 exception");
        }
        return "get index page successfully.";
    }
}
