package com.talenco.tasksystem.service;

import com.talenco.tasksystem.entity.Step;

import java.util.List;

public interface StepService {

    List<Step> getAll();

    Step getOne(Long id);

    void insert(Step step);

    void update(Step step);

    /**
     * 在删除项目时,删除项目下的步骤,该功能不影响主要供能,可后续完成
     * @param ids 项目id数组
     */
    void delete(Long[] ids);

    List<Step> searchByProjectId(Long projectId);

    List<Step> searchByCheckMan(String username);
}
