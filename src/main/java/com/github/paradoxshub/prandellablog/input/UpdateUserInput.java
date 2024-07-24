package com.github.paradoxshub.prandellablog.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateUserInput {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "username")
    @NotBlank(message = "username is required")
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min =  6, max = 64)
    private String username;

    @JsonProperty(value = "password")
    @NotBlank(message = "password is required")
    private String password;

    @JsonProperty(value = "email")
    @NotBlank(message = "email is required")
    @Email
    private String email;

    @JsonProperty(value = "nickname")
    @NotBlank(message = "nickname is required")
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String nickname;

    @JsonProperty(value = "gender")
    private int gender;

    @JsonProperty(value = "age")
    private int age;

    public UpdateUserInput(String username, String password, String email, String nickname, int gender, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {this.gender = gender;}

    public int getAge(){return age;}

    public void setAge(int age) {this.age = age;}
}
