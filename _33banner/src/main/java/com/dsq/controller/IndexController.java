package com.dsq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aa on 2019/7/24.
 */

@RestController
public class IndexController {

    @RequestMapping(value = "")
    public String index(){
        return "Hello world!";
    }
}
