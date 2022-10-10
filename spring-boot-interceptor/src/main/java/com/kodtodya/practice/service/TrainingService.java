package com.kodtodya.practice.service;

import com.kodtodya.practice.model.Training;
import com.kodtodya.practice.repo.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private static final Logger logger = LoggerFactory.getLogger(TrainingService.class);

    @Autowired
    private TrainingRepository repo;

    public List<Training> retrieveTrainings() {
        logger.info("/inside the TrainingService.getTrainings()");
        return repo.retrieve();
    }

    public boolean storeTraining(Training training) {
        logger.info("/inside the TrainingService.addTraining()");
        return repo.store(training);
    }

    public boolean deleteTraining(int id) {
        logger.info("/inside the TrainingService.removeTraining()");
        return repo.delete(id);
    }

    public Training search(int id) {
        logger.info("/inside the TrainingService.search()");
        return repo.search(id);
    }
}
