package com.kodtodya.practice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrainingExceptionController {

    @ExceptionHandler(value = TrainingNotfoundException.class)
    public ResponseEntity<Object> exception(TrainingNotfoundException exception) {
        return new ResponseEntity<>("Training not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TrainingNotfoundToDeleteException.class)
    public ResponseEntity<Object> exception(TrainingNotfoundToDeleteException exception) {
        return new ResponseEntity<>("Training not found to delete", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoTrainingsInDatabaseException.class)
    public ResponseEntity<Object> exception(NoTrainingsInDatabaseException exception) {
        return new ResponseEntity<>("No Trainings in the database", HttpStatus.NOT_FOUND);
    }
}
