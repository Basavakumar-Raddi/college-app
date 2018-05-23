package com.kumar.college.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @RequestMapping("/hello")
    public String helloEmployee() {
        return "Greetings from Employee Spring Boot!";
    }
}
