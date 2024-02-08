package com.amson.threadExecutorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		System.out.println(String.format("Java Version: %s", System.getProperty("java.version")));
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
