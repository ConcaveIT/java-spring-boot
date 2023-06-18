package com.advpro.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

	// @Autowired Environment env;

	// @Bean
	// public DataSource dataSource() {
	//     final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	//     dataSource.setDriverClassName(env.getProperty("driverClassName"));
	//     dataSource.setUrl(env.getProperty("url"));
	//     dataSource.setUsername(env.getProperty("user"));
	//     dataSource.setPassword(env.getProperty("password"));	    
	//     return dataSource;
	// }

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
