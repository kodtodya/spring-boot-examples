package com.kodtodya.practice.batch.jobs.csvToDb.listener;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.core.io.Resource;

import java.io.File;

@Slf4j
public class JobCompletionNotificationListener implements JobExecutionListener {

  private Resource[] resources;

  public JobCompletionNotificationListener(Resource[] resources) {
    this.resources = resources;
  }

  @SneakyThrows
  @Override
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("JOB FINISHED !!");
      if (resources == null) {
        log.info("No resource to delete");
      }
      for (Resource r : resources) {
        File file = r.getFile();
        boolean deleted = file.delete();
        log.info((deleted ? "File deleted: " : "Could not delete file ") + file.getPath());
      }
    }
  }
}