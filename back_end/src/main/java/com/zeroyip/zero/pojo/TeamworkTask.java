package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TeamworkTask {
    private Integer taskNum;

    private Integer groupNum;

    private Date taskCreateTime;

    private String taskContent;

    private String taskTrustee;

    private Date taskFinishedTime;

    private String taskFinished;

    private String taskExpired;

    public Integer getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(Integer taskNum) {
        this.taskNum = taskNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    public String getTaskTrustee() {
        return taskTrustee;
    }

    public void setTaskTrustee(String taskTrustee) {
        this.taskTrustee = taskTrustee == null ? null : taskTrustee.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTaskFinishedTime() {
        return taskFinishedTime;
    }

    public void setTaskFinishedTime(Date taskFinishedTime) {
        this.taskFinishedTime = taskFinishedTime;
    }

    public String getTaskFinished() {
        return taskFinished;
    }

    public void setTaskFinished(String taskFinished) {
        this.taskFinished = taskFinished == null ? null : taskFinished.trim();
    }

    public String getTaskExpired() {
        return taskExpired;
    }

    public void setTaskExpired(String taskExpired) {
        this.taskExpired = taskExpired == null ? null : taskExpired.trim();
    }
}