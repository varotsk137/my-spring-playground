package com.playground.scheduler.controller;

import com.playground.scheduler.job.ScheduleRandomNumberJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping(value = "/random")
    public void getRandomNumber() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduleRandomNumberJob.class)
                .withIdentity("Qrtz_Job_Detail")
                .withDescription("Invoke Random number job.")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("Qrtz_Trigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(4))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
