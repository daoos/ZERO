package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Memorandum {
    private Integer memNum;

    private String userEmail;

    private Date memCreateTime;

    private String memTitle;

    private String memContent;

    public Integer getMemNum() {
        return memNum;
    }

    public void setMemNum(Integer memNum) {
        this.memNum = memNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getMemCreateTime() {
        return memCreateTime;
    }

    public void setMemCreateTime(Date memCreateTime) {
        this.memCreateTime = memCreateTime;
    }

    public String getMemTitle() {
        return memTitle;
    }

    public void setMemTitle(String memTitle) {
        this.memTitle = memTitle == null ? null : memTitle.trim();
    }

    public String getMemContent() {
        return memContent;
    }

    public void setMemContent(String memContent) {
        this.memContent = memContent == null ? null : memContent.trim();
    }
}