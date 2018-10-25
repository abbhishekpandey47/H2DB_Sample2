package com.sample.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMainClass {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainClass.class, args);
	}

}

