package com.cto.loggerexample.demologger;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemologgerApplication {

	private static Logger logger = LogManager.getRootLogger();

	public static void main(String[] args) {
		logger.info("Starting the springboot app...");
		SpringApplication.run(DemologgerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			logger.info("Inspecting the beans provided by Spring Boot");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
				logger.info("Bean - " + beanName);
			}

			logger.info("All beans up to date.");

		};
	}
}
