package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUserOutput {

    @JsonProperty(value = "id")
    private Long id;


    public RegisterUserOutput(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
