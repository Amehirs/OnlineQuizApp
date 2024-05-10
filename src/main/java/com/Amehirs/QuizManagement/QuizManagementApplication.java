package com.Amehirs.QuizManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Amehirs.QuizManagement")
public class QuizManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizManagementApplication.class, args);
	}

}
