package com.dsq.listener;

import com.dsq.bean.UserBean;
import com.dsq.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by aa on 2019/7/20.
 */

@Component
public class RegisterListener implements ApplicationListener<UserRegisterEvent>{

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        UserBean user = event.getUser();
        System.out.println("ApplicationListener 注册信息： " + user.getName());
    }
}
