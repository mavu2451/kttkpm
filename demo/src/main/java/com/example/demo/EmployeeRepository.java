package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findEmployeeByLastName(String lastname);
    List<Employee> findEmployeeByLastNameContaining(String str);

}

