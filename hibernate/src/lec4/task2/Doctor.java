package lec4.task2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private double salary;

    @OneToOne(mappedBy = "doctor")
    private DoctorDetails doctorDetails;

    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patients;

    public Doctor() {
    }

    public Doctor(long id, String userName, double salary) {
        this.id = id;
        this.userName = userName;
        this.salary = salary;
    }

    public Doctor(String userName, double salary) {
        this.userName = userName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
