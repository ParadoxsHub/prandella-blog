package com.github.paradoxshub.prandellablog.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.paradoxshub.prandellablog.entity.LoginHistory;
import com.github.paradoxshub.prandellablog.entity.User;
import com.github.paradoxshub.prandellablog.util.ServletUtil;

import java.sql.Timestamp;
import java.time.Instant;

public class LoginHistoryOutput {
    private Long id;

    @JsonProperty
    private static Long user_id;

    @JsonProperty
    private static String user_agent;

    @JsonProperty
    private Timestamp login_at;

    @JsonProperty
    private static String ip_address;

    @JsonProperty
    private static Boolean login_success;

    @JsonProperty
    private static String failure_reason;


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

    public LoginHistoryOutput(String failure_reason) {
        this.failure_reason = failure_reason;
    }

    public LoginHistoryOutput(Long user_id,Boolean login_success) {
        this.user_id = user_id;
        this.login_success = login_success;
    }

    public LoginHistoryOutput(Long user_id, String user_agent, Timestamp login_at, String ip_address, Boolean login_success, Boolean failure_reason, String failureReason) {
        this.user_id = user_id;
        this.user_agent = user_agent;
        this.login_at = login_at;
        this.ip_address = ip_address;
        this.login_success = login_success;
        this.failure_reason = failureReason;
    }

    public LoginHistoryOutput() {
    }

    public static LoginHistoryOutput of(LoginHistory loginHistory) {
        LoginHistoryOutput output = new LoginHistoryOutput();
        if(loginHistory == null) {
            return output;
        }
        output.setId(loginHistory.getId());
        output.setUser_id(loginHistory.getUser_id());
        output.setLogin_at(Timestamp.from(Instant.now()));
        output.setFailure_reason(loginHistory.getFailure_reason());
        output.setLogin_success(loginHistory.getLogin_success());
        output.setUser_agent(ServletUtil.getUserAgent());
        output.setIp_address(ServletUtil.getIpAddr());
        return output;
    }

}
