package com.zeroyip.zero.pojo;

public class Manager {
    private String managerId;

    private String managerPsw;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getManagerPsw() {
        return managerPsw;
    }

    public void setManagerPsw(String managerPsw) {
        this.managerPsw = managerPsw == null ? null : managerPsw.trim();
    }
}