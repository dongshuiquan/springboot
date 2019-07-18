package com.dsq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aa on 2019/7/18.
 */

@RestController
public class IndexController {

    @RequestMapping(value = "/cors")
    public String corsIndex() {
        return "this is cors info";
    }
}
