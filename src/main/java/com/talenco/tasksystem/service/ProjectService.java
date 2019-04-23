package com.talenco.tasksystem.service;


import com.talenco.tasksystem.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAll();

    Project getOne(Long id);

    Long insert(Project project);

    void update(Project project);

    /**
     * 在删除项目时,删除项目下的步骤step,该功能不影响主要供能,可后续完成
     * @param ids 项目id数组
     */
    void delete(Long[] ids);
}
