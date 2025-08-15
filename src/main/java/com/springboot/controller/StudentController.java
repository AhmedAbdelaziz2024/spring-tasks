package com.springboot.controller;

import com.springboot.dto.StudentDTO;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private  StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudentsWithTeachers() {
        return studentService.getAllStudentsWithTeachers();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentWithTeachersById(@PathVariable Long id) {
        return studentService.getStudentWithTeachersById(id);
    }
}
