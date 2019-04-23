package com.talenco.tasksystem.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Task {
    //    任务ID
    private Long taskId;
    //    任务名称
    private String taskName;
    //    项目id
    private Long projectId;
    //    项目名
    private String projectName;
    //    用户名
    private String username;
    //    任务状态
    private Long taskStatus;
    //    任务状态步骤列表
    private String taskStepStatus;
}
