package com.zeroyip.zero.pojo;

public class Filter {
    private Integer filterNum;

    private String managerId;

    private String filterContent;

    public Integer getFilterNum() {
        return filterNum;
    }

    public void setFilterNum(Integer filterNum) {
        this.filterNum = filterNum;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getFilterContent() {
        return filterContent;
    }

    public void setFilterContent(String filterContent) {
        this.filterContent = filterContent == null ? null : filterContent.trim();
    }
}