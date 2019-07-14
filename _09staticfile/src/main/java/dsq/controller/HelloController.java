package dsq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aa on 2019/7/14.
 */

@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello world!";
    }
}
