package com.dsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 2018/12/13.
 */

@Controller
public class JspController {

    @RequestMapping("test2")
    public String index() {
        return "test2";
    }

}
