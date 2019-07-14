package com.dsq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aa on 2019/7/13.
 */

@RestController
@RequestMapping
public class HelloWordController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "HelloWorld";
    }
}
