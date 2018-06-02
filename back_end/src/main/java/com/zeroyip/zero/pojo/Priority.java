package com.zeroyip.zero.pojo;

public class Priority {
    private String priorityLevel;

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel == null ? null : priorityLevel.trim();
    }
}