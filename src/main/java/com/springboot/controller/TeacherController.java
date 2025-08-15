package com.springboot.controller;

import com.springboot.dto.TeacherDTO;
import com.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachersWithStudents() {
        return teacherService.getAllTeachersWithStudents();
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherWithStudentsById(@PathVariable Long id) {
        return teacherService.getTeacherWithStudentsById(id);
    }
}