package com.kodtodya.practice.scheduler;

import com.kodtodya.practice.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

@Configuration("reportScheduler")
@EnableScheduling
public class ReportScheduler {

    @Autowired
    private PartnerRepository partnerRepository;

    @Scheduled(cron="#{@reportScheduler.getReportSchedulerCronValue('apple')}")
    public void test() {
        System.out.println("Generating report for Apple Current time is: " + LocalTime.now());
    }

    @Bean
    public String getReportSchedulerCronValue(String partnerName) {
        return partnerRepository.findSchedulerByName(partnerName).get().getScheduler();
    }
}
