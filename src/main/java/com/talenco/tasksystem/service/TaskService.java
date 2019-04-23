package com.talenco.tasksystem.service;

import com.talenco.tasksystem.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getOne(Long id);

    Long insert(Task task);

    void update(Task task);

    /**
     * 删除任务
     * @param ids
     */
    void delete(Long[] ids);

    List<Task> searchByProjectId(Long projectId);

    List<Task> searchByUsername(String username);
}
