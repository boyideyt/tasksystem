package com.talenco.tasksystem.service;

import com.talenco.tasksystem.entity.Task;
import com.talenco.tasksystem.entity.User;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getOne(Long id);

    void insert(Task task);

    void update(Task task);

    void delete(Long[] ids);

    List<Task> searchByProjectName(String projectId);

    List<Task> searchByUsername(String username);
}
