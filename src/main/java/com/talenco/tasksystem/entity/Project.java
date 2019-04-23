package com.talenco.tasksystem.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    // 项目模板路径
    private String samplePath;
    // 项目状态
    private Long projectStatus;
    // 步骤计数
    private Long stepCount;

}
