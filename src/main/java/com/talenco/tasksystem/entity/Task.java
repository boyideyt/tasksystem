package com.talenco.tasksystem.entity;

import java.util.List;

public class Task {
    //    任务ID
    private Long taskId;
    //    项目ID
    private Long projectID;
    //    用户ID
    private Long userID;
    //    项目步骤描述
    private List<String> taskStepList;
    //    项目步骤状态
    private List<Long> taskStepStatus;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public List<String> getTaskStepList() {
        return taskStepList;
    }

    public void setTaskStepList(List<String> taskStepList) {
        this.taskStepList = taskStepList;
    }

    public List<Long> getTaskStepStatus() {
        return taskStepStatus;
    }

    public void setTaskStepStatus(List<Long> taskStepStatus) {
        this.taskStepStatus = taskStepStatus;
    }
}
