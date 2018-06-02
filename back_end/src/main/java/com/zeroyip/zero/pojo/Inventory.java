package com.zeroyip.zero.pojo;

public class Inventory {
    private Integer invNum;

    private String userEmail;

    private String invTitle;

    public Integer getInvNum() {
        return invNum;
    }

    public void setInvNum(Integer invNum) {
        this.invNum = invNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getInvTitle() {
        return invTitle;
    }

    public void setInvTitle(String invTitle) {
        this.invTitle = invTitle == null ? null : invTitle.trim();
    }
}