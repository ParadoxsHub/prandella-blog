package com.github.paradoxshub.prandellablog.Input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class InsertUserInput {

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

    public InsertUserInput(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
