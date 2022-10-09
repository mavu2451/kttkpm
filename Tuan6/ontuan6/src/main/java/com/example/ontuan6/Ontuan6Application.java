package com.example.ontuan6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Ontuan6Application {

	public static void main(String[] args) {
		SpringApplication.run(Ontuan6Application.class, args);
	}

}
