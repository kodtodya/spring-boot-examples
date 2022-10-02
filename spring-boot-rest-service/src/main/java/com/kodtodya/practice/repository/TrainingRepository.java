package com.kodtodya.practice.repository;

import com.kodtodya.practice.domain.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingRepository implements EntryRepository{
    private static final Logger logger = LoggerFactory.getLogger(TrainingRepository.class);
    private List<Training> trainingList = new ArrayList<Training>();
    private int index = -1;

    public String store(Training training) {
        logger.info("/inside the TrainingRepository.store()");
        training.setId(++index);
        trainingList.add(index, training);
        return training.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the TrainingRepository.delete()");
        trainingList.remove(id);
        return "training removed";
    }

    @Override
    public List<Training> retrieve() {
        logger.info("/inside the TrainingRepository.retrieve()");
        return trainingList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the TrainingRepository.search()");
        return this.trainingList.get(index).toString();
    }

    @Override
    public String update(Training training) {
        logger.info("/inside the TrainingRepository.search()");
        if (training.getPrerequisite().isBlank() || training.getPrerequisite().isEmpty()) {
            this.trainingList.get(index).setPrerequisite(training.getPrerequisite());
        }
        if (training.getDuration() > 0) {
            this.trainingList.get(index).setDuration(training.getDuration());
        }
        return this.trainingList.get(index).toString();
    }
}