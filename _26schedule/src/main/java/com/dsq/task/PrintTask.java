package com.dsq.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by aa on 2019/7/18.
 */

@Component
public class PrintTask {

    /**
     *
     */
    @Scheduled(cron = "2 * * * * *")
    public void cron() {
        System.out.println("执行测试cron时间 ： " + new Date());
    }

    /**
     * 上一个调用后次调用的延时调用时间
     * @throws InterruptedException
     */
    //@Scheduled(fixedRate = 1000 * 1)
    public void fixedRate() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("fixedRate 时间： " + new Date());
    }

    /**
     * 上一个调用完成后再次调用的延时调用时间
     * @throws Exception
     */
   // @Scheduled(fixedDelay = 1000 * 1)
    public void fixDelay() throws Exception {
        Thread.sleep(3000);
        System.out.println("fixedDelay时间 : " + new Date());
    }

    @Scheduled(initialDelay = 1000 * 10, fixedDelay = 1000 * 2)
    public void initialDelay() {
        System.out.println("initialDelay 时间 ： " + new Date());
    }
}
