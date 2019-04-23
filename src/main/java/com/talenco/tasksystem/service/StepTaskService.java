package com.talenco.tasksystem.service;

import com.talenco.tasksystem.entity.Step;
import com.talenco.tasksystem.entity.StepTask;

import java.util.List;

public interface StepTaskService {

    List<StepTask> getAll();

    StepTask getOne(Long id);

    void insert(List<Step> steps,Long taskId);

    void update(StepTask stepTask);

    /**
     * 在删除任务task时,删除项目下的步骤stepTask,该功能不影响主要供能,可后续完成
     * @param ids 项目id数组
     */
    void delete(Long[] ids);

    List<StepTask> searchByTaskId(Long projectId);

    List<StepTask> searchByUsername(String username);
}
