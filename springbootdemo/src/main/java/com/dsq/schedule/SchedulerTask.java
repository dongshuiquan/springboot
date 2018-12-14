package com.dsq.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2018/12/13.
 */
@Component
public class SchedulerTask {

    private int count=0;

    @Scheduled(cron="*/2 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

}
