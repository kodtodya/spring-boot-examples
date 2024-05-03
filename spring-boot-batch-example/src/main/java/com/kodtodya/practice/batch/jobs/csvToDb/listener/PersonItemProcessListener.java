package com.kodtodya.practice.batch.jobs.csvToDb.listener;

import com.kodtodya.practice.batch.jobs.csvToDb.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

@Slf4j
public class PersonItemProcessListener implements ItemProcessListener<Person, Person> {

  @Override
  public void beforeProcess(Person input) {
    log.info("Person record has been read: " + input);
  }

  @Override
  public void afterProcess(Person input, Person result) {
    log.info("Person record has been processed to : " + result);
  }

  @Override
  public void onProcessError(Person input, Exception e) {
    log.error("Error in reading the person record : " + input);
    log.error("Error in reading the person record : " + e);
  }
}
