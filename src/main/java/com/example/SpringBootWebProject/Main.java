package com.example.SpringBootWebProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.SpringBootWebProject.service.mapper")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		//ModelMapper m = new ModelMapper();
		//m.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return new ModelMapper();
	}
}
