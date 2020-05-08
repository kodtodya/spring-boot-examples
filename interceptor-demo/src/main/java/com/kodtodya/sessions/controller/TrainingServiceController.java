package com.kodtodya.sessions.controller;

import com.kodtodya.sessions.beans.Training;
import com.kodtodya.sessions.repo.TrainingRepository;
import com.kodtodya.sessions.services.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingServiceController {
   private static final Logger logger = LoggerFactory.getLogger(TrainingRepository.class);

   @Autowired
   private TrainingService servcie;

   @RequestMapping(value = "/trainings")
   public ResponseEntity<List<Training>> getTrainings() {
      logger.info("/trainings request got invoked..inside the controller");
      return new ResponseEntity<List<Training>>((List<Training>) servcie.retrieveTrainings(), HttpStatus.OK);
   }

   @PostMapping(value = "/addTraining")
   public ResponseEntity<String> addTraining(@RequestParam(name = "name") String name, @RequestParam(name = "duration") int duration, @RequestParam(name = "prerequisite") String prerequisite) {
      logger.info("/addTraining request got invoked..inside the controller");
      Training training = new Training(name,duration,prerequisite);
      return new ResponseEntity<String>(servcie.storeTraining(training)?"Training added to list":"Training NOT added to list", HttpStatus.OK);
   }

   @DeleteMapping(value = "/removeTraining")
   public ResponseEntity<String> removeTraining(int id) {
      logger.info("/removeTraining request got invoked..inside the controller");
      return new ResponseEntity<String>(servcie.deleteTraining(id)?"Training removed from list":"Training NOT removed from list", HttpStatus.OK);
   }

   @GetMapping(value = "/searchTraining")
   public ResponseEntity<String> search(int id) {
      logger.info("/search request got invoked..inside the controller");
      return new ResponseEntity<String>(servcie.search(id).toString(), HttpStatus.OK);
   }
}