package com.kodtodya.practice.service;

import com.kodtodya.practice.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    //@Bean
    public String getReportSchedulerCronValue(String partnerName) {
        return partnerRepository.findSchedulerByName(partnerName).get().getScheduler();
    }
}
