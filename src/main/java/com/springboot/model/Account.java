package com.springboot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String password;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Post> posts;


    public Account() {
    }

    public Account(Long id, String name, Integer age, String password, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.posts = posts;
    }

    public Account(String name, Integer age, String password, List<Post> posts) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.posts = posts;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}