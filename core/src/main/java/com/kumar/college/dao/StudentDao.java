package com.kumar.college.dao;

import com.kumar.college.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, String > {

}
