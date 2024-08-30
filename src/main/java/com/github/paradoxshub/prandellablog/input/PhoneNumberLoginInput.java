package com.github.paradoxshub.prandellablog.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PhoneNumberLoginInput {

    @JsonProperty(value = "username")
    @NotBlank(message = "username is required")
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min = 6,max = 16)
    private String username;

    @JsonProperty(value = "password")
    @NotBlank(message = "password is required")
    private String password;

    public PhoneNumberLoginInput(String username, String password) {
        this.username = username;
        this.password = password;
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
}
