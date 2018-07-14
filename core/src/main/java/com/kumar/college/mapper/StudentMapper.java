package com.kumar.college.mapper;

import com.kumar.college.entity.Student;
import com.kumar.college.info.StudentDto;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//@Mapper(componentModel = "spring", uses = DateMapper.class) -- used in case of date mapper if necessary
@Mapper(componentModel = "spring")
@DecoratedWith(StudentMapperDecorator.class)
public interface StudentMapper {

    @Mappings({
            @Mapping(source = "id", target="studentId"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(target = "country", constant="India")

    })
    StudentDto studentToStudentDto(Student student);
    @InheritInverseConfiguration
    Student studentDtoToStudent(StudentDto studentDto);
}
