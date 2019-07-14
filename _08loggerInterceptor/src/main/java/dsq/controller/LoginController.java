package dsq.controller;

import com.alibaba.fastjson.JSONObject;
import dsq.entity.UserEntity;
import dsq.jpa.UserJPA;
import dsq.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by aa on 2019/7/14.
 */

@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/login")
    public JSONObject login(UserEntity user, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        result.put("msg", "用户 : " +  user.getName() + "，登录成功。");
        request.setAttribute(LoggerUtil.LOGGER_RETURN, result);
        request.getSession().setAttribute("_session_user", result);
        return result;
    }
}
