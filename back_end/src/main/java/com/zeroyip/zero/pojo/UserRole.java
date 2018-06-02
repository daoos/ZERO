package com.zeroyip.zero.pojo;

public class UserRole {
    private String userEmail;

    private String userPsw;

    private Integer groupNum;

    private String memberRole;

    private String memberPermission;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberPermission() {
        return memberPermission;
    }

    public void setMemberPermission(String memberPermission) {
        this.memberPermission = memberPermission;
    }
}
