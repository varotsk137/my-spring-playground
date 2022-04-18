package com.playground.scheduler.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAsync
public class SpringScheduler {

    private static final int FIXED_DELAY_TASK_1 = 5*1000*60;
    private static final int FIXED_RATE_TASK_1 = 3*60*1000;


    @Scheduled(fixedDelay = FIXED_DELAY_TASK_1)
    public void scheduleFixedDelayTask1(){
        log.info("Fixed Delay Interval: {}", FIXED_DELAY_TASK_1);
    }

    @Scheduled(fixedRate = FIXED_RATE_TASK_1)
    public void scheduleFixedRateTask(){
        log.info("Fixed Rate Interval: {}", FIXED_RATE_TASK_1);

    }

    @Async
    @Scheduled(fixedRate = FIXED_RATE_TASK_1)
    public void scheduleFixedRateTaskAsync(){
        log.info("Fixed Rate Interval Async: {}", FIXED_RATE_TASK_1);
//        try {
//            Thread.sleep(FIXED_RATE_TASK_1+10000);
//        } catch (InterruptedException e) {
//        }
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void scheduleCronTaskEveryMinutes(){
        log.info("Trigger Cron every minute!!");
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void scheduleCronTaskEveryFiveMinutes(){
        log.info("Trigger Cron every five minute!!");
    }

    @Scheduled(cron = "0 */30 */1 * * *")
    public void scheduleCronTaskEveryHourAndAHalf(){
        log.info("Trigger Cron every hour and a half!!");
    }

    @Scheduled(cron = "0 30 12 * * *")
    public void scheduleCronTaskEveryDayAtNoon(){
        log.info("Trigger Cron at 12.30 every day!!");
    }

    @Scheduled(cron = "0 0 */1 * * *")
    public void scheduleCronTaskEveryHours(){
        log.info("Trigger Cron every hour!!");
    }

    @Scheduled(cron = "0 */3 * * * *", zone = "Asia/Bangkok")
    public void scheduleCronEveryThreeMinuteBkkTimezone(){
        log.info("Trigger Cron every 3 minute with timezone!!");
    }


}
