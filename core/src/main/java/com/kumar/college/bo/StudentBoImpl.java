package com.kumar.college.bo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.kumar.college.dao.StudentDao;
import com.kumar.college.entity.Student;
import com.kumar.college.info.StudentDto;
import com.kumar.college.mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;

@Named
public class StudentBoImpl implements StudentBo {

    @Inject
    private StudentDao studentDao;

    @Autowired
    private StudentMapper studentMapper;

    @Override public List<StudentDto> getAllStudents() {
         List<Student> stdList = studentDao.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        /*StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("student1Firstname");
        studentDto.setLastname("student1Lastname");*/
        StudentDto studentDto = studentMapper.studentToStudentDto(stdList.get(0));
        Student student = studentMapper.studentDtoToStudent(studentDto);
        studentDtos.add(studentDto);
        return studentDtos;
    }
}
