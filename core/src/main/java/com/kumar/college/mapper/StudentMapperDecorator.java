package com.kumar.college.mapper;

import com.kumar.college.entity.Student;
import com.kumar.college.info.StudentDto;
import com.kumar.college.util.CollegeUtil;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentMapperDecorator implements StudentMapper{

    @Autowired
    private StudentMapper studentMapper;

    @Override public StudentDto studentToStudentDto(final Student student) {
        StudentDto studentDto = studentMapper.studentToStudentDto(student);
        studentDto.setFullName(CollegeUtil.getMergedString(student.getFirstName(),student.getLastName()));
        return studentDto;
    }

    @Override public Student studentDtoToStudent(final StudentDto studentDto) {
        Student student = studentMapper.studentDtoToStudent(studentDto);
        String[] names = studentDto.getFullName().split(" ");
        student.setFirstName(names[0]);
        student.setLastName(names[0]);
        return student;
    }
}
