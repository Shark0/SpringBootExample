package com.shark.example.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    @Scheduled(initialDelay = 10000, fixedDelay = 10000)
    public void delayTask() {
        System.out.println("delayTask : " + System.currentTimeMillis());
    }
}
