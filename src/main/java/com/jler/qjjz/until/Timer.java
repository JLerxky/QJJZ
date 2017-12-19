package com.jler.qjjz.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Timer {
    Logger logger = LoggerFactory.getLogger(Interceptor.class);
/*
*  fixedRate 任务两次执行时间间隔是任务的开始点，而 fixedDelay 的间隔是前次任务的结束与下次任务的开始
* */
//    @Scheduled(fixedDelay=ONE_Minute)
//    public void fixedDelayJob(){
//        logger.info(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>fixedDelay执行....");
//    }
//
//    @Scheduled(fixedRate=1000)
//    public void fixedRateJob(){
//        logger.info(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+" >>fixedRate执行....");
//    }

//    @Scheduled(cron = "30 * * * * ?")
//    public void cronJob() {
//        logger.info(new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + " >>cron执行....");
//    }

}
