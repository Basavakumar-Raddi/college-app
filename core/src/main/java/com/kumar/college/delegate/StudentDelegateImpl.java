package com.kumar.college.delegate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.kumar.college.bo.StudentBo;
import com.kumar.college.info.StudentDto;

@Named
public class StudentDelegateImpl implements StudentDelegate {

    @Inject
    private StudentBo studentBo;

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtos = studentBo.getAllStudents();
        return studentDtos;
    }
}
