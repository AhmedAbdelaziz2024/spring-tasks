package com.springboot.service;

import com.springboot.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudentsWithTeachers();
    StudentDTO getStudentWithTeachersById(Long id);
}
