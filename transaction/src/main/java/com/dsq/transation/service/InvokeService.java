package com.dsq.transation.service;

import com.dsq.transation.entity.User1;
import com.dsq.transation.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvokeService {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

    public void deleteAll() {
        user1Service.delelte();
        user2Service.delete();
    }


    public void notransaction_exception_required_required(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    public void notransaction_required_required_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

}
