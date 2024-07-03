package com.github.paradoxshub.prandellablog.entity;

public class User {
    private String username;
    private String id;
    private String password;
    private int PhoneNumber;
    private String email;

    public User(String username, String id, String password, int phoneNumber, String email) {
        this.username = username;
        this.id = id;
        this.password = password;
        PhoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
