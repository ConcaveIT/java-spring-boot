package com.learn.topic01.service;

import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Service
public class TodoService {

    public TodoService(DataSource dataSource) {
    }

    // Use the dataSource in your methods...
}
