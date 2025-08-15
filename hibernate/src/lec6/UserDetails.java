package lec6;

import javax.persistence.*;

@Entity
public class UserDetails {
    //- User details with attribute id , address, phone
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DETAILS_ID")
    private long id;

    private String address;

    private String phone;

    //- user has only userDetails
    @OneToOne(mappedBy = "userDetails")
    private User user;

    public UserDetails() {
    }

    public UserDetails(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
