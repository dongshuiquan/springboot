package com.dsq.transation.service;

import com.dsq.transation.entity.User1;
import com.dsq.transation.entity.User2;
import com.dsq.transation.mapper.User1Mapper;
import com.dsq.transation.mapper.User2Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User2Service {

    private static final Logger logger = LoggerFactory.getLogger(User2Service.class);

    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(){
        user2Mapper.delete();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User2 user){
        user2Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }

}
