package com.playground.scheduler.job;

import com.playground.scheduler.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleRandomNumberJob implements Job {

    @Autowired
    private JobService jobService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Random number is {}, ", jobService.executeRandomNumberJob());
    }
}
