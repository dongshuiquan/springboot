package com.dsq.event;

import com.dsq.bean.UserBean;
import org.springframework.context.ApplicationEvent;

/**
 * Created by aa on 2019/7/20.
 */
public class UserRegisterEvent extends ApplicationEvent {

    private UserBean user;


    public UserRegisterEvent(Object source, UserBean user) {
        super(source);
        this.user = user;
    }

    public UserBean getUser() {
        return user;
    }
}
