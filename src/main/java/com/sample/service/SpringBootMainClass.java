package com.sample.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootMainClass {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainClass.class, args);
	}
	/*
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/school/getData").allowedOrigins("http://localhost:4200");
	            }
	        };
	    }*/

}

