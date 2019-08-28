package dsq.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aa on 2019/7/13.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "index")
    @ResponseBody
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)

    public String loginAction() {
        System.out.println("loginAction");
        return "index";
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "security", method = RequestMethod.GET)
    @ResponseBody
    public String security() {
        System.out.println("loginAction");
        return "index";
    }

    @PreAuthorize("#id<10")
    @RequestMapping("find")
    @ResponseBody
    public String find(int id) {
        System.out.println("find user by id........." + id);
        return id + "";
    }

}
