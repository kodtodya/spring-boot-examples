package com.kodtodya.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication implements ApplicationRunner {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info(" Total NonOptionArgs: {}", args.getNonOptionArgs().size());
		args.getNonOptionArgs().forEach( logger::info);
		logger.info(" Total OptionArgs: {}", args.getOptionNames().size());
		args.getOptionNames().forEach(name -> logger.info("{} = {}",name, args.getOptionValues(name)));
	}
}
