package com.advpro.payment.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    // @Bean
    // public DataSource dataSource() {
    //     DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    //     dataSourceBuilder.driverClassName("org.sqlite.JDBC");
    //     dataSourceBuilder.url("jdbc:sqlite:data.sqlite");
        
    //     return dataSourceBuilder.build();
    // }
    
}