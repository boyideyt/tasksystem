package com.talenco.tasksystem.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StepTask {
    //步骤任务id
    private Long stepTaskId;
    //步骤id
    private Long stepId;
    //步骤名
    private String stepName;
    //任务id
    private Long taskId;
    //步骤附件链接
    private String stepLink;
    //步骤状态
    private Long stepStatus;
    //步骤索引
    private Long stepIndex;
    //最后处理用户
    private String username;
    //最后更改时间
    private String updateTime;

}
