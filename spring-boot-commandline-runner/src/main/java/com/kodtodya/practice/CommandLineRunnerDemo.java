package com.kodtodya.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CommandLineRunnerDemo implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(CommandLineRunnerDemo.class);

	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Total NonOptionArgs: {}", args.length);
		Arrays.stream(args).forEach(name -> logger.info("{} = {}", name, args));
	}
}
