package com.kodtodya.practice.repository;

import com.kodtodya.practice.domain.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingRepository implements EntiryRepository {
    private static final Logger logger = LoggerFactory.getLogger(TrainingRepository.class);
    private final List<Training> trainingList = new ArrayList<Training>();
    private int index = -1;

    @Override
    public boolean store(Training training) {
        logger.info("/inside the TrainingRepository.store()");
        training.setId(++index);
        trainingList.add(index, training);
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("/inside the TrainingRepository.delete()");
        trainingList.remove(id);
        return true;
    }

    @Override
    public List<Training> retrieve() throws Exception {
        logger.info("/inside the TrainingRepository.retrieve()");
        return trainingList;
    }

    @Override
    public Training search(int index) throws Exception {
        logger.info("/inside the TrainingRepository.search()");
        return this.trainingList.get(index);
    }
}
