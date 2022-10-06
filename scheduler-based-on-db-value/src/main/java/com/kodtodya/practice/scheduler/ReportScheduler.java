package com.kodtodya.practice.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

@Configuration("reportScheduler")
@EnableScheduling
public class ReportScheduler {

    @Scheduled(cron="0 0/1 * ? * *")
    //@Scheduled(cron="#{@partnerService.getReportSchedulerCronValue('apple')}")
    public void test() {
        System.out.println("Generating report for Apple Current time is: " + LocalTime.now());
    }
}
