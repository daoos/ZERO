package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TeamworkMessage {
    private Integer messNum;

    private Integer groupNum;

    private Date messTime;

    private String messInitiator;

    private String message;

    public Integer getMessNum() {
        return messNum;
    }

    public void setMessNum(Integer messNum) {
        this.messNum = messNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getMessTime() {
        return messTime;
    }

    public void setMessTime(Date messTime) {
        this.messTime = messTime;
    }

    public String getMessInitiator() {
        return messInitiator;
    }

    public void setMessInitiator(String messInitiator) {
        this.messInitiator = messInitiator == null ? null : messInitiator.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}