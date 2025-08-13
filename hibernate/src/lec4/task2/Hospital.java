package lec4.task2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int numberOfDoctors;

    private int numberOfPatient;

    @OneToMany(mappedBy = "hospital")
    private Set<Doctor> doctors ;

    @ManyToMany(mappedBy = "hospitals")
    private List<Patient> patients;

    public Hospital() {
    }

    public Hospital(long id, String name, int numberOfDoctors, int numberOfPatient) {
        this.id = id;
        this.name = name;
        this.numberOfDoctors = numberOfDoctors;
        this.numberOfPatient = numberOfPatient;
    }

    public Hospital(String name, int numberOfDoctors, int numberOfPatient) {
        this.name = name;
        this.numberOfDoctors = numberOfDoctors;
        this.numberOfPatient = numberOfPatient;
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

    public int getNumberOfDoctors() {
        return numberOfDoctors;
    }

    public void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    public int getNumberOfPatient() {
        return numberOfPatient;
    }

    public void setNumberOfPatient(int numberOfPatient) {
        this.numberOfPatient = numberOfPatient;
    }

}
