package com.talenco.tasksystem.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Task {
    //    任务ID
    private Long taskId;
    //    项目名
    private String projectName;
    //    用户名
    private String userName;
    //    任务步骤描述
    private String taskStepList;
    //    任务步骤状态
    private String taskStepStatus;
    //    任务步骤链接
    private String taskStepLink;
    //    任务状态
    private Long taskStatus;
    //    任务名称
    private String taskName;


}
