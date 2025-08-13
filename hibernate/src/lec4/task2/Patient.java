package lec4.task2;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String typeOfDisease;

    @ManyToOne
    private Doctor doctor;

    @ManyToMany
    private List<Hospital> hospitals;

    public Patient() {
    }

    public Patient(long id, String typeOfDisease, String name) {
        this.id = id;
        this.typeOfDisease = typeOfDisease;
        this.name = name;
    }

    public Patient(String name, String typeOfDisease) {
        this.name = name;
        this.typeOfDisease = typeOfDisease;
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

    public String getTypeOfDisease() {
        return typeOfDisease;
    }

    public void setTypeOfDisease(String typeOfDisease) {
        this.typeOfDisease = typeOfDisease;
    }
}
