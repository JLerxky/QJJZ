package com.jler.qjjz.until;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Timer {
    public final static long ONE_Minute =  60 * 1000;

//    @Scheduled(fixedDelay=ONE_Minute)
//    public void fixedDelayJob(){
//        System.out.println(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>fixedDelay执行....");
//    }
//
//    @Scheduled(fixedRate=ONE_Minute)
//    public void fixedRateJob(){
//        System.out.println(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>fixedRate执行....");
//    }

    @Scheduled(cron="0 43 * * * ?")
    public void cronJob(){
        System.out.println(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>cron执行....");
    }

}
