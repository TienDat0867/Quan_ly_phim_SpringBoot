package com.poly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoMoviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMoviewApplication.class, args);
	}

}
