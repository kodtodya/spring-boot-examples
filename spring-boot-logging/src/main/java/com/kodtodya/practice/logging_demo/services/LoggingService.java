package com.kodtodya.practice.logging_demo.services;

import com.kodtodya.practice.logging_demo.controllers.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public String log(){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}
