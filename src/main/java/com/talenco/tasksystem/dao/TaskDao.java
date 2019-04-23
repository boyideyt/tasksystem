package com.talenco.tasksystem.dao;


import com.talenco.tasksystem.entity.Task;

import java.util.List;


public interface TaskDao {

    List<Task> getAll();

    Task getOne(Long id);

    int insert(Task task);

    void update(Task task);

    void delete(Long id);

    List<Task> searchByProjectId(Long projectId);

    List<Task> searchByUsername(String username);
}
