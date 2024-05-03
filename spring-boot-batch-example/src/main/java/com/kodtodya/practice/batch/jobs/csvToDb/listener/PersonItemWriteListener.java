package com.kodtodya.practice.batch.jobs.csvToDb.listener;

import com.kodtodya.practice.batch.jobs.csvToDb.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;

@Slf4j
public class PersonItemWriteListener implements ItemWriteListener<Person> {

  @Override
  public void beforeWrite(Chunk<? extends Person> items) {
    log.info("Writing started persons list : " + items);
  }

  @Override
  public void afterWrite(Chunk<? extends Person> items) {
    log.info("Writing completed persons list : " + items);
  }

  @Override
  public void onWriteError(Exception e, Chunk<? extends Person> items) {
    log.error("Error in reading the person records " + items);
    log.error("Error in reading the person records " + e);
  }
}
