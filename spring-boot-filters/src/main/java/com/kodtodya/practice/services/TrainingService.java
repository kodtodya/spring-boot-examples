package com.kodtodya.practice.services;

import com.kodtodya.practice.domain.Training;
import com.kodtodya.practice.exceptions.NoTrainingsInDatabaseException;
import com.kodtodya.practice.exceptions.TrainingNotfoundException;
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
        List<Training> list = null;
        try {
            list = repo.retrieve();
        } catch (Exception exception) {

        }
        if (0 == list.size())
            throw new NoTrainingsInDatabaseException();
        return list;
    }

    public boolean storeTraining(Training training) {
        logger.info("/inside the TrainingService.addTraining()");
        return repo.store(training);
    }

    public boolean deleteTraining(int id) {
        logger.info("/inside the TrainingService.removeTraining()");
        try {
            repo.delete(id);
        } catch (Exception exception) {
            throw new TrainingNotfoundException();
        }
        return true;
    }

    public Training search(int id) {
        logger.info("/inside the TrainingService.search()");
        Training training = null;
        try {
            training = repo.search(id);
        } catch (Exception exception) {
            throw new TrainingNotfoundException();
        }
        return training;
    }
}
