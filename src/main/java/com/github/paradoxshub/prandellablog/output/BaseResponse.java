package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.paradoxshub.prandellablog.common.ErrorCode;
import com.github.paradoxshub.prandellablog.common.ErrorMessage;

import java.util.Objects;


public class BaseResponse implements Response {

    @JsonProperty(value = "code")
    Long code = 0L;

    @JsonProperty(value = "message")
    String message = "";

    @JsonProperty(value = "data")
    Object data = null;

    public static BaseResponse ok(Object data) {
        return new BaseResponse(ErrorCode.success, ErrorMessage.success, data);
    }

    public static BaseResponse error(Object data) {
        return new BaseResponse(ErrorCode.error, ErrorMessage.error, data);
    }

    public BaseResponse(Long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse() {
    }

    public BaseResponse(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseResponse response = (BaseResponse) o;
        return Objects.equals(code, response.code) && Objects.equals(message, response.message) && Objects.equals(data, response.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(code);
        result = 31 * result + Objects.hashCode(message);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }
}
