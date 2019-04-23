package com.talenco.tasksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.talenco.tasksystem.dao")
public class TasksystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksystemApplication.class, args);
    }

}

