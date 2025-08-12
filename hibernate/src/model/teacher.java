package model;

import org.hibernate.annotations.Check;

import javax.persistence.*;


@Entity
@Check(constraints = "age BETWEEN 15 AND 20")
@Table(name = "TEACHER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "address")
})
public class teacher {
    @Id
    private long id;
    @Column(length = 50)
    private String name;
    private int age;
    private String address;

    public teacher() {
    }

    public teacher(long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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
        if (age < 15 || age > 20) {
            throw new IllegalArgumentException("age must be between 15 and 20");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
