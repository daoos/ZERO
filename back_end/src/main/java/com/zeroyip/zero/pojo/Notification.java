package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Notification {
    private Integer noticeNum;

    private String managerId;

    private Date noticeSendTime;

    private String noticeTitle;

    private String noticeContent;

    private String noticeReceiver;

    private String noticeRead;

    public Integer getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(Integer noticeNum) {
        this.noticeNum = noticeNum;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getNoticeSendTime() {
        return noticeSendTime;
    }

    public void setNoticeSendTime(Date noticeSendTime) {
        this.noticeSendTime = noticeSendTime;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticeReceiver() {
        return noticeReceiver;
    }

    public void setNoticeReceiver(String noticeReceiver) {
        this.noticeReceiver = noticeReceiver == null ? null : noticeReceiver.trim();
    }

    public String getNoticeRead() {
        return noticeRead;
    }

    public void setNoticeRead(String noticeRead) {
        this.noticeRead = noticeRead == null ? null : noticeRead.trim();
    }
}