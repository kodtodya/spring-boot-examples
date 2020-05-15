package com.kodtodya.sessions.scheduler;

import com.kodtodya.sessions.beans.Training;
import com.kodtodya.sessions.exceptions.NoTrainingsInDatabaseException;
import com.kodtodya.sessions.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class TrainingInsertionScheduler {

    private int counter=-1;

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
        System.out.println("Time to display all the training as per fixed delay. If no trainings in DB, then will not print anything.");
        try{
            for( Training training : service.retrieveTrainings())
                System.out.println(training);
        } catch (Exception exception){}
    }

  /*  @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void printTrainingEntriesWithFixedDRate() {
        System.out.println("Time to display all the training as per fixed rate. If no trainings in DB, then will not print anything.");
        try{
            for( Training training : service.retrieveTrainings())
                System.out.println(training);
        } catch (Exception exception){}
    }*/
}
