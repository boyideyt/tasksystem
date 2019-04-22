package com.talenco.tasksystem.entity;

import java.util.ArrayList;

import lombok.*;

@Getter
@Setter
@ToString
public class Project {

    //项目ID
    private Long projectId;
    //项目名称
    private String projectName;
    //项目描述,项目总体要求
    private String projectDescription;
    // 项目步骤数
    private Long projectStepNum;
    // 项目步骤描述
    private String projectStepList;
    // 项目模板路径
    private String samplePath;
    // 项目状态
    private Long projectStatus;
}
