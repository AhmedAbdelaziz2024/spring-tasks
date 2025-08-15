package com.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {

    private Long id;

    @NotBlank(message = "Email name must not be empty")
    private String name;

    @Email(message = "Invalid email format")
    private String content;

    private Long employeeId;

    public EmailDTO() {
    }

    public EmailDTO(Long id, String name, String content, Long employeeId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.employeeId = employeeId;
    }

    public EmailDTO(String name, String content, Long employeeId) {
        this.name = name;
        this.content = content;
        this.employeeId = employeeId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
