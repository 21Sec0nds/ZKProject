package com.example.grep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class GrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrepApplication.class, args);
		System.out.print("============================\n" +
				"SERVER READY \n" +
				"============================ ");
	}

}
