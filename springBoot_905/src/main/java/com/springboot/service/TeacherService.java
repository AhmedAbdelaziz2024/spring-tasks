package com.springboot.service;

import com.springboot.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachersWithStudents();
    TeacherDTO getTeacherWithStudentsById(Long id);
}
