package com.playground.scheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobService {

    public int executeRandomNumberJob() {
        return (int) (Math.random()*100+1);
    }
}
