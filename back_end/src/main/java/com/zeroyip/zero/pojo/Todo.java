package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {
    private Integer todoNum;

    private String userEmail;

    private Date todoCreateTime;

    private String todoContent;

    private Date todoReminderTime;

    private String invTitle;

    private String filterContent;

    private String priorityLevel;

    private Date todoFinishedTime;

    private String todoFinished;

    private String todoExpired;

    public Integer getTodoNum() {
        return todoNum;
    }

    public void setTodoNum(Integer todoNum) {
        this.todoNum = todoNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getTodoCreateTime() {
        return todoCreateTime;
    }

    public void setTodoCreateTime(Date todoCreateTime) {
        this.todoCreateTime = todoCreateTime;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent == null ? null : todoContent.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTodoReminderTime() {
        return todoReminderTime;
    }

    public void setTodoReminderTime(Date todoReminderTime) {
        this.todoReminderTime = todoReminderTime;
    }

    public String getInvTitle() {
        return invTitle;
    }

    public void setInvTitle(String invTitle) {
        this.invTitle = invTitle == null ? null : invTitle.trim();
    }

    public String getFilterContent() {
        return filterContent;
    }

    public void setFilterContent(String filterContent) {
        this.filterContent = filterContent == null ? null : filterContent.trim();
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel == null ? null : priorityLevel.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTodoFinishedTime() {
        return todoFinishedTime;
    }

    public void setTodoFinishedTime(Date todoFinishedTime) {
        this.todoFinishedTime = todoFinishedTime;
    }

    public String getTodoFinished() {
        return todoFinished;
    }

    public void setTodoFinished(String todoFinished) {
        this.todoFinished = todoFinished == null ? null : todoFinished.trim();
    }

    public String getTodoExpired() {
        return todoExpired;
    }

    public void setTodoExpired(String todoExpired) {
        this.todoExpired = todoExpired == null ? null : todoExpired.trim();
    }
}