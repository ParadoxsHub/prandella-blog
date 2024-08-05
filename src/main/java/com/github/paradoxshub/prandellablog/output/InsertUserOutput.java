package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;

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
