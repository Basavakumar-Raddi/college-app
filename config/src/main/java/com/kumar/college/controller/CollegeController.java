package com.kumar.college.controller;

import java.util.List;

import javax.inject.Inject;

import com.kumar.college.delegate.StudentDelegate;
import com.kumar.college.info.StudentDto;
import com.kumar.college.response.ResponseObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coll")
@Slf4j
public class CollegeController {

    @Inject
    private StudentDelegate studentDelegate;

    @RequestMapping("/hello")
    public String helloCollege() {
        log.info("testting application");
        return "Greetings from College using Spring Boot!";

    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject<List<StudentDto>> getAllStudents() {
        ResponseObject<List<StudentDto>> responseObject = new ResponseObject<>();
        try {
            log.info("getting students started");
            List<StudentDto> studentList = studentDelegate.getAllStudents();
            responseObject.setSuccess(Boolean.TRUE);
            responseObject.setResponse(studentList);
            responseObject.setMessage("student list fetched successfully");
        } catch(Exception e){
            log.error("Exception occurred : ",e);
            responseObject.setSuccess(Boolean.FALSE);
            responseObject.setMessage("Error occured while fetching the student list");
        }
        log.info("done getting students");
        return responseObject;
    }
}
