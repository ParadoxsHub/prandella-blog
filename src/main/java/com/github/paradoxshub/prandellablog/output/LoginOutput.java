package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginOutput {
    @JsonProperty
    private String message;

    @JsonProperty
    private String token;

    public LoginOutput(String message,String token) {
        this.message = message;
        this.token = token;
    }

    public LoginOutput(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
