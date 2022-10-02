package com.kodtodya.practice.service;

import com.kodtodya.practice.domain.Training;
import com.kodtodya.practice.repository.TrainingRepository;
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

    public String storeTraining(Training training) {
        logger.info("/inside the TrainingService.addTraining()");
        return repo.store(training);
    }

    public String deleteTraining(int id) {
        logger.info("/inside the TrainingService.removeTraining()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the TrainingService.search()");
        return repo.search(id);
    }

    public String updateTraining(int id, Training training) {
        logger.info("/inside the TrainingService.updateTraining()");
        training.setId(id);
        return repo.update(training);
    }
}