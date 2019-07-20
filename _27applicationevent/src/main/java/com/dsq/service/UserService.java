package com.dsq.service;

import com.dsq.bean.UserBean;
import com.dsq.event.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by aa on 2019/7/20.
 */

@Service
public class UserService {

    @Autowired
    ApplicationContext applicationContext;

    public void register(UserBean userBean) {
        applicationContext.publishEvent(new UserRegisterEvent(this, userBean));
    }
}
