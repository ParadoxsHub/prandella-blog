package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserOutput {
    @JsonProperty(value = "id")
    private Long id;

    public UpdateUserOutput(Long id) {
        this.id = id;
    }
}
