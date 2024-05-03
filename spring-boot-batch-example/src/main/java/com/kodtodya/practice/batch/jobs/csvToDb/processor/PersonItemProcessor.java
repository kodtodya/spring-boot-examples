package com.kodtodya.practice.batch.jobs.csvToDb.processor;

import com.kodtodya.practice.batch.jobs.csvToDb.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  @Override
  public Person process(Person person) throws Exception {
    //...
    log.info("Processed record: " + person);
    return person;
  }
}
