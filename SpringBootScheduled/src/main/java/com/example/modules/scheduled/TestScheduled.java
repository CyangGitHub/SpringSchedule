package com.example.modules.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2016/11/21.
 */
@Component
public class TestScheduled {
    private static final SimpleDateFormat dateFromat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 5000)
    public void task1(){
        System.out.println("每隔五秒执行一次 "+dateFromat.format(new Date()));
    }

    @Scheduled(cron = "0 15 * * * ?")
    public void task2(){
        System.out.println("每天每个小时的第15分钟执行一次: "+dateFromat.format(new Date()));
    }

}