package com.github.paradoxshub.prandellablog.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

public class RegisterUserInput {

    @JsonProperty(value = "username")
    @NotBlank(message = "username is required")
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min =  6, max = 16)
    private String username;

//    @Value("${aes.key}")
    @JsonProperty(value = "firstPassword")
    @NotBlank(message = "firstPassword is required")
    private String firstPassword;

    @JsonProperty(value = "secondPassword")
    @NotBlank(message = "secondPassword is required")
    private String secondPassword;

    @JsonProperty(value = "email")
    @NotBlank(message = "email is required")
    @Email
    private String email;

    @JsonProperty(value = "nickname")
    @NotBlank(message = "nickname is required")
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min =  6, max = 16)
    private String nickname;

    public RegisterUserInput(String username, String firstPassword, String secondPassword, String email, String nickname) {
        this.username = username;
        this.firstPassword = firstPassword;
        this.secondPassword = secondPassword;
        this.email = email;
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {return nickname;}

    public void setNickname(String nickname) {this.nickname = nickname;}

}
