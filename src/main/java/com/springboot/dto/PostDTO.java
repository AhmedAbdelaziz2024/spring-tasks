package com.springboot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostDTO {

    private Long id;

    @NotNull(message = "Text must not be null")
    @Size(min = 20, message = "Text must have at least 20 characters")
    private String text;

    private String imagePath;

    private Long accountId;

    public PostDTO() {
    }

    public PostDTO(Long id, String text, String imagePath, Long accountId) {
        this.id = id;
        this.text = text;
        this.imagePath = imagePath;
        this.accountId = accountId;
    }

    public PostDTO(String text, String imagePath, Long accountId) {
        this.text = text;
        this.imagePath = imagePath;
        this.accountId = accountId;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
