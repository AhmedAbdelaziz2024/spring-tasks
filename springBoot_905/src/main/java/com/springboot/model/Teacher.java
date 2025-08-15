package com.springboot.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students;

    public Teacher() {
    }

    public Teacher(Long id, String name, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Teacher(String name, Set<Student> students) {
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
