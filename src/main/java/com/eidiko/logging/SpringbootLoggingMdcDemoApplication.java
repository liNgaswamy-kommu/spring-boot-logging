package com.eidiko.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootLoggingMdcDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootLoggingMdcDemoApplication.class, args);
		System.err.println("*** Welcome to Logging & MDC ***");
	}

}
