package com.zeroyip.zero.pojo;

public class TeamworkMembers {
    private String userEmail;

    private String userAvatarPath;

    private Integer memberNum;

    private Integer groupNum;

    private String groupName;

    private String groupMember;

    private String memberRole;

    private String memberPermission;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatarPath() {
        return userAvatarPath;
    }

    public void setUserAvatarPath(String userAvatarPath) {
        this.userAvatarPath = userAvatarPath;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember == null ? null : groupMember.trim();
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole == null ? null : memberRole.trim();
    }

    public String getMemberPermission() {
        return memberPermission;
    }

    public void setMemberPermission(String memberPermission) {
        this.memberPermission = memberPermission == null ? null : memberPermission.trim();
    }
}