package com.oguzhan.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component //Spring Container
public class ScheduledExample {

     //second-minute-hour-day-month-which day of week
    @Scheduled(cron = "*/5 * * * * *") //run every 5 second
    public void write1To2() {
        for(int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
    }
}
