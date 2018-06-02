package com.zeroyip.zero.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserSetting {
    private Date lastChangeTime;

    private String userEmail;

    private String language;

    private String stratingPage;

    private String dateRecognise;

    private String invite;

    private String dateFormat;

    private String websiteNotice;

    private String noticeRule;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Date lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getStratingPage() {
        return stratingPage;
    }

    public void setStratingPage(String stratingPage) {
        this.stratingPage = stratingPage == null ? null : stratingPage.trim();
    }

    public String getDateRecognise() {
        return dateRecognise;
    }

    public void setDateRecognise(String dateRecognise) {
        this.dateRecognise = dateRecognise == null ? null : dateRecognise.trim();
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite == null ? null : invite.trim();
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat == null ? null : dateFormat.trim();
    }

    public String getWebsiteNotice() {
        return websiteNotice;
    }

    public void setWebsiteNotice(String websiteNotice) {
        this.websiteNotice = websiteNotice == null ? null : websiteNotice.trim();
    }

    public String getNoticeRule() {
        return noticeRule;
    }

    public void setNoticeRule(String noticeRule) {
        this.noticeRule = noticeRule == null ? null : noticeRule.trim();
    }
}