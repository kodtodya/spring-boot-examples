package com.kodtodya.practice.controller;

import com.kodtodya.practice.model.Training;
import com.kodtodya.practice.repo.TrainingRepository;
import com.kodtodya.practice.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TrainingServiceController {
    private static final Logger logger = LoggerFactory.getLogger(TrainingRepository.class);

    @Autowired
    private TrainingService service;

    @RequestMapping(value = "/training")
    public ResponseEntity<List<Training>> getTrainings() {
        logger.info("/trainings request got invoked..inside the controller");
        return new ResponseEntity<List<Training>>((List<Training>) service.retrieveTrainings(), HttpStatus.OK);
    }

    @PostMapping(value = "/training")
    public ResponseEntity<String> addTraining(@RequestParam(name = "name") String name, @RequestParam(name = "duration") int duration, @RequestParam(name = "prerequisite") String prerequisite) {
        logger.info("/addTraining request got invoked..inside the controller");
        Training training = new Training(name, duration, prerequisite);
        return new ResponseEntity<String>(service.storeTraining(training) ? "Training added to list" : "Training NOT added to list", HttpStatus.OK);
    }

    @DeleteMapping(value = "/training/{id}")
    public ResponseEntity<String> removeTraining(@PathVariable int id) {
        logger.info("/removeTraining request got invoked..inside the controller");
        return new ResponseEntity<String>(service.deleteTraining(id) ? "Training removed from list" : "Training NOT removed from list", HttpStatus.OK);
    }

    @GetMapping(value = "/training/{id}")
    public ResponseEntity<String> search(@PathVariable int id) {
        logger.info("/search request got invoked..inside the controller");
        return new ResponseEntity<String>(service.search(id).toString(), HttpStatus.OK);
    }
}