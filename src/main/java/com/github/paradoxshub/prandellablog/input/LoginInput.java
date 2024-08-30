package com.github.paradoxshub.prandellablog.input;

import cn.hutool.core.builder.Builder;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginInput {

    @JsonProperty(value = "username")
//    @NotBlank(message = "username is required")
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min = 6,max = 16)
    private String username;

    @JsonProperty(value = "email")
//    @NotBlank(message = "email is required")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @JsonProperty(value = "phonenumber")
//    @NotBlank(message = "phonenumber is required")
    @Pattern(regexp = "^\\+?[0-9]{1,3}\\-?[0-9]{10,12}$")
    private String phonenumber;

    @JsonProperty(value = "password")
    @NotBlank(message = "password is required")
    private String password;

    public LoginInput(String username, String email, String phonenumber, String password) {
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
