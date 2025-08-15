package com.springboot.dto;

public class TeacherSimpleDTO {
    private Long id;
    private String name;

    public TeacherSimpleDTO() {
    }

    public TeacherSimpleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeacherSimpleDTO(String name) {
        this.name = name;
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
}
