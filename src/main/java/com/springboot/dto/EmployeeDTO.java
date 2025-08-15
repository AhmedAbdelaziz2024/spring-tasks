package com.springboot.dto;

import jakarta.validation.constraints.*;

import java.util.List;


public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name must not be null or empty")
    private String name;

    @Min(value = 16, message = "Age must be greater than 15")
    @Max(value = 39, message = "Age must be less than 40")
    private Integer age;

    @DecimalMin(value = "5001", message = "Salary must be greater than 5000")
    @DecimalMax(value = "9999", message = "Salary must be less than 10000")
    private Double salary;

    private List<EmailDTO> emails;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, Integer age, Double salary, List<EmailDTO> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.emails = emails;
    }

    public EmployeeDTO(String name, Integer age, Double salary, List<EmailDTO> emails) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.emails = emails;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }
}
