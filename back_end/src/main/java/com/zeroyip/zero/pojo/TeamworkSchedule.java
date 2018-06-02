package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TeamworkSchedule {
    private Integer schNum;

    private Integer groupNum;

    private Date schCreateTime;

    private String schContent;

    private Date schTime;

    public Integer getSchNum() {
        return schNum;
    }

    public void setSchNum(Integer schNum) {
        this.schNum = schNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getSchCreateTime() {
        return schCreateTime;
    }

    public void setSchCreateTime(Date schCreateTime) {
        this.schCreateTime = schCreateTime;
    }

    public String getSchContent() {
        return schContent;
    }

    public void setSchContent(String schContent) {
        this.schContent = schContent == null ? null : schContent.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getSchTime() {
        return schTime;
    }

    public void setSchTime(Date schTime) {
        this.schTime = schTime;
    }
}