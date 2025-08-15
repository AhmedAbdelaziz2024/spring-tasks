package com.springboot.model;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Post() {
    }

    public Post(Long id, String text, String imagePath, Account account) {
        this.id = id;
        this.text = text;
        this.imagePath = imagePath;
        this.account = account;
    }

    public Post(String text, String imagePath, Account account) {
        this.text = text;
        this.imagePath = imagePath;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
