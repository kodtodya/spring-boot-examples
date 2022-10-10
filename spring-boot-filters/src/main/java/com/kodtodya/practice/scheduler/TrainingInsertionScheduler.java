package com.kodtodya.practice.scheduler;

import com.kodtodya.practice.domain.Training;
import com.kodtodya.practice.services.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TrainingInsertionScheduler {

    private static final Logger logger = LoggerFactory.getLogger(TrainingInsertionScheduler.class);

    private int counter = -1;

    @Autowired
    private TrainingService service;

    // At second :00, every 5 minutes starting at minute :00, of every hour
    @Scheduled(cron = "0 0/5 * * * ?")
    // after each 30 seconds
    //@Scheduled(cron = "0/1 * * * * ?")
    public void insertTrainingInDB() {
        Random random = new Random();
        String name = "Demo training-" + ++counter;

        Training training = new Training(name, random.nextInt(), "dummy pre-requisite");
        service.storeTraining(training);
    }

    @Scheduled(fixedDelay = 300000, initialDelay = 300000)
    public void printTrainingEntriesWithFixedDelay() {
        logger.info("Time to display all the training as per fixed delay. If no trainings in DB, then will not print anything.");
        this.logAllTrainings();
    }

    /*@Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void printTrainingEntriesWithFixedDRate() {
        logger.info("Time to display all the training as per fixed rate. If no trainings in DB, then will not print anything.");
        this.logAllTrainings();
    }*/

    private void logAllTrainings() {
        try {
            for (Training training : service.retrieveTrainings())
                logger.info(training.toString());
        } catch (Exception exception) {
        }
    }
}
