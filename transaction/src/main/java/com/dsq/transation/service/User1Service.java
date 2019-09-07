package com.dsq.transation.service;

import com.dsq.transation.entity.User1;
import com.dsq.transation.mapper.User1Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User1Service {

    private static final Logger logger = LoggerFactory.getLogger(User1Service.class);

    @Autowired
    private User1Mapper user1Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void delelte(){
        user1Mapper.delete();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user){
        user1Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User1 user){
        user1Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User1 user){
        user1Mapper.insert(user);
    }

}
