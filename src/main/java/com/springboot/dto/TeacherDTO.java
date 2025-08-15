package com.springboot.dto;

import java.util.Set;

public class TeacherDTO {
    private Long id;
    private String name;
    private Set<StudentSimpleDTO> students;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, Long id, Set<StudentSimpleDTO> students) {
        this.name = name;
        this.id = id;
        this.students = students;
    }

    public TeacherDTO(String name, Set<StudentSimpleDTO> students) {
        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentSimpleDTO> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentSimpleDTO> students) {
        this.students = students;
    }
}
