package com.kodtodya.practice.controller;

import com.kodtodya.practice.domain.Training;
import com.kodtodya.practice.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	//@RequestMapping(path = "/training", method = RequestMethod.GET)
	@GetMapping("/training")
	public List<Training> retrieveTrainings() {
		log.info("inside retrieveTraining() method..");
		return trainingService.retrieveTrainings();
	}

	@GetMapping("/training/{trainingId}")
	public String retrieveTrainingForTrainingId(@PathVariable int trainingId) {
		return trainingService.search(trainingId);
	}

	@DeleteMapping("/training/{trainingId}")
	public String deleteTrainingForTrainingId(@PathVariable int trainingId) {
		return trainingService.deleteTraining(trainingId);
	}

	@PostMapping("/training")
	public String addTraining(@RequestBody Training training) {
		return trainingService.storeTraining(training);
	}

	@PutMapping("/training/{trainingId}")
	public String updateTrainingForTrainingId(@PathVariable int trainingId, @RequestBody Training training) {
		return trainingService.updateTraining(trainingId, training);
	}
}
