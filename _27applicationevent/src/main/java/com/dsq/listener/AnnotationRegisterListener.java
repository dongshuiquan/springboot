package com.dsq.listener;

import com.dsq.bean.UserBean;
import com.dsq.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by aa on 2019/7/20.
 */

@Component
public class AnnotationRegisterListener {

    @EventListener
    public void register(UserRegisterEvent event) {
        UserBean user = event.getUser();
        System.out.println("@EventListener 注册信息， 用户名：" + user.getName());
    }
}
