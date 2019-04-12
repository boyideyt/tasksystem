package com.talenco.tasksystem.entity;

import java.util.ArrayList;

public class Project {


    //项目ID
    private Long projectId;
    //项目名称
    private String projectName;
    //项目描述
    private String projectDescription;
    // 项目步骤数
    private Long projectStepNum;
    // 项目步骤描述
    private ArrayList<String> projectStepList;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Long getProjectStepNum() {
        return projectStepNum;
    }

    public void setProjectStepNum(Long projectStepNum) {
        this.projectStepNum = projectStepNum;
    }

    public ArrayList<String> getProjectStepList() {
        return projectStepList;
    }

    public void setProjectStepList(ArrayList<String> projectStepList) {
        this.projectStepList = projectStepList;
    }
}
