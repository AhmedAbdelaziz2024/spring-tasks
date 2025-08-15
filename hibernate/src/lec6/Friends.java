package lec6;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Friends {
    //- Frinds with attribute id , name
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FRIEND_ID")
    private long id;

    private String name;

    @ManyToMany(mappedBy = "friends")
    private List<User> users = new ArrayList<>();;

    public Friends() {
    }

    public Friends(String name) {
        this.name = name;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
