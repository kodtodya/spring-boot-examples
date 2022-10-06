package com.kodtodya.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunnerDemo implements ApplicationRunner {

	private static Logger logger = LoggerFactory.getLogger(ApplicationRunnerDemo.class);

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		logger.info(" Total NonOptionArgs: {}", args.getNonOptionArgs().size());
		args.getNonOptionArgs().forEach( logger::info);
		logger.info(" Totla OptionArgs: {}", args.getOptionNames().size());
		args.getOptionNames().forEach(name -> logger.info("{} = {}",name, args.getOptionValues(name)));
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunnerDemo.class, args);
	}
}
