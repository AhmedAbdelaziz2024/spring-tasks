package com.springboot.dto;

import java.util.Set;

public class StudentDTO {

        private Long id;

        private String name;

        private Set<TeacherSimpleDTO> teachers;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, Set<TeacherSimpleDTO> teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }

    public StudentDTO(String name, Set<TeacherSimpleDTO> teachers) {
        this.name = name;
        this.teachers = teachers;
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

    public Set<TeacherSimpleDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherSimpleDTO> teachers) {
        this.teachers = teachers;
    }
}
