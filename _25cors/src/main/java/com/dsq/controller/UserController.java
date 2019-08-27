package com.dsq.controller;

import com.dsq.entity.User;
import com.dsq.result.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aa on 2019/7/21.
 */

@Controller
public class UserController {

   // @PostMapping("user/login")
    @ResponseBody
    public ApiResult login(@RequestBody User user) {

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        Map<String,Map<String, String>> result = new HashMap<>();

        Map<String, String > data = new HashMap<>();
        data.put("msg", "login success");
        result.put("data", data);

        ApiResult apiResult = new ApiResult("api success");
        return apiResult;

//        return result;
    }

    @PostMapping("user/login")
    @ResponseBody
    public Map<String, Object> login2(@RequestBody User user) {

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

       Map<String, Object> result = new HashMap<>();

        result.put("msg", "login success");
        result.put("token", "login token");
        result.put("message", "message");
        result.put("code", 20000);
        return result;
    }

}
