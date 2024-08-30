package com.github.paradoxshub.prandellablog.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class LoginHistory {
    private Long id;
    private Long user_id;
    private String user_agent;
    private Timestamp login_at;
    private String ip_address;
    private Boolean login_success;
    private String failure_reason;

    public LoginHistory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public Timestamp getLogin_at() {
        return login_at;
    }

    public void setLogin_at(Timestamp login_at) {
        this.login_at = login_at;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Boolean getLogin_success() {
        return login_success;
    }

    public void setLogin_success(Boolean login_success) {
        this.login_success = login_success;
    }

    public String getFailure_reason() {
        return failure_reason;
    }

    public void setFailure_reason(String failure_reason) {
        this.failure_reason = failure_reason;
    }

    public LoginHistory(Long id, Long user_id, String user_agent, Timestamp login_at, String ip_address, Boolean login_success, String failure_reason) {
        this.id = id;
        this.user_id = user_id;
        this.user_agent = user_agent;
        this.login_at = login_at;
        this.ip_address = ip_address;
        this.login_success = login_success;
        this.failure_reason = failure_reason;
    }
}
