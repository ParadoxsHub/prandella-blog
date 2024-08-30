package com.github.paradoxshub.prandellablog.output;

import com.github.paradoxshub.prandellablog.entity.LoginHistory;

import java.util.List;

public class LoginHistoryListOutput {

    private Long total;
    private List<LoginHistory> list;

    public LoginHistoryListOutput(Long total, List<LoginHistory> list) {
        this.total = total;
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<LoginHistory> getList() {
        return list;
    }

    public void setList(List<LoginHistory> list) {
        this.list = list;
    }

}
