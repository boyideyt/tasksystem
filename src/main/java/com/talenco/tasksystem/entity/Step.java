package com.talenco.tasksystem.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Step {
    //步骤id
    private Long stepId;
    //步骤名
    private String stepName;
    //项目id
    private Long projectId;
    //步骤索引
    private Long stepIndex;
    //审核账号
    private String checkMan;
}
