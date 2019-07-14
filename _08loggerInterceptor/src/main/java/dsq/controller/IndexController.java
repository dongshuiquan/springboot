package dsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aa on 2019/7/13.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "hello")
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "user/login_view")
    public String login_view() {
        return "user/login_view";
    }

    @RequestMapping(value = "/user/index")
    public String index2() {
        return "user/index";
    }
}
