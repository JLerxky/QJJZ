package com.jler.qjjz.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Timer {
    Logger logger = LoggerFactory.getLogger(Interceptor.class);

//    @Scheduled(fixedDelay=ONE_Minute)
//    public void fixedDelayJob(){
//        logger.info(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>fixedDelay执行....");
//    }
//
//    @Scheduled(fixedRate=ONE_Minute)
//    public void fixedRateJob(){
//        logger.info(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>fixedRate执行....");
//    }

//    @Scheduled(cron = "30 * * * * ?")
//    public void cronJob() {
//        logger.info(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + " >>cron执行....");
//    }

}
