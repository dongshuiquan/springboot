package com.dsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aa on 2019/7/13.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("name", "Dong");
        return "index";
    }
}
