package com.github.paradoxshub.prandellablog.Output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class InsertUserOutput  {

    @JsonProperty(value = "id")
    private Long id;

//    public static InsertUserOutput failed(Long id) {
//        InsertUserOutput output = new InsertUserOutput(id);
//        output
//        return new InsertUserOutput(id);
//    }


    public InsertUserOutput(Long id) {
        this.id = id;
    }
}
