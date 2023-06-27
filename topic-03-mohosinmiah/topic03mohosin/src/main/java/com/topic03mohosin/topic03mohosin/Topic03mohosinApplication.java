package com.topic03mohosin.topic03mohosin;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Topic03mohosinApplication {

	// Added configuration for model mapper
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


	public static void main(String[] args) {
		SpringApplication.run(Topic03mohosinApplication.class, args);
	}

}
