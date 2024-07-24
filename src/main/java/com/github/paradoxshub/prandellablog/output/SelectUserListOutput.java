package com.github.paradoxshub.prandellablog.output;

import java.sql.Timestamp;
import java.util.List;

public class SelectUserListOutput {

    private Long total;
    private List<SelectUserOutput> list;

    public SelectUserListOutput(Long total, List<SelectUserOutput> list) {
        this.total = total;
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<SelectUserOutput> getList() {
        return list;
    }

    public void setList(List<SelectUserOutput> list) {
        this.list = list;
    }
}
