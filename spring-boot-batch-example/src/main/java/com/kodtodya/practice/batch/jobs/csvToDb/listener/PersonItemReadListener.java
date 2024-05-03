package com.kodtodya.practice.batch.jobs.csvToDb.listener;

import com.kodtodya.practice.batch.jobs.csvToDb.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;

@Slf4j
public class PersonItemReadListener implements ItemReadListener<Person> {

  @Override
  public void beforeRead() {
    log.info("Reading a new Person Record");
  }

  @Override
  public void afterRead(Person input) {
    log.info("New Person record read : " + input);
  }

  @Override
  public void onReadError(Exception e) {
    log.error("Error in reading the person record : " + e);
  }
}
