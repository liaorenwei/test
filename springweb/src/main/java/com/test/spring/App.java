package com.test.spring;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	@Bean
	public ExecutorService  createExecutorService() {
		return Executors.newFixedThreadPool(2);
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(App.class, args);
	}
}
