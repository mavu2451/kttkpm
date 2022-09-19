package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Employ {
@Autowired
private EmployeeRepository repository;
    public void insertFourEmployee(EmployeeRepository repository) {
        Employee employee = Employee.builder().firstName("khang11").lastName("khi11").email("ntk@gmail.com").build();
        this.repository.save(employee);
    }

    @Bean
    public CommandLineRunner run() {
        return (args -> {
            insertFourEmployee(repository);
            System.out.println(repository.findAll());
        });
    }
}
