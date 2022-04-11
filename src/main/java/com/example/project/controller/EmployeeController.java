package com.example.project.controller;


import com.example.project.dto.Employee;
import com.example.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/employees/age")
    public ResponseEntity<List<List<Employee>>> getAllByAge(){
        return new ResponseEntity<>(employeeService.getAllByAge(), HttpStatus.OK);
    }
    @GetMapping("/employees/{age}")
    public ResponseEntity<List<Employee>> getByAge(@PathVariable("age") int age){
        return new ResponseEntity<>(employeeService.getByAge(age),HttpStatus.OK);
    }
}
