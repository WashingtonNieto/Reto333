package com.example.Reto333.Reto333;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

//@EntityScan(basePackages = {com.example.Reto333.Reto333})
@SpringBootApplication
public class Reto333Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto333Application.class, args);
	}

}
