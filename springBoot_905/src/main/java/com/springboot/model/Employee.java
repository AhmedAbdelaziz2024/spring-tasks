package com.springboot.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    private double salary;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Email> emails;

    public Employee() {
    }

    public Employee(long id, String name, int age, double salary, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.emails = emails;
    }

    public Employee(String name, int age, double salary, List<Email> emails) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.emails = emails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
