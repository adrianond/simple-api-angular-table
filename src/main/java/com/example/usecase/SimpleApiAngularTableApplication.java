package com.example.usecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.database.repository")
@EntityScan("com.example.database.entity")
@ComponentScan("com.example.domain.converter")
@ComponentScan("com.example.http")
@SpringBootApplication
public class SimpleApiAngularTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApiAngularTableApplication.class, args);
	}

}
