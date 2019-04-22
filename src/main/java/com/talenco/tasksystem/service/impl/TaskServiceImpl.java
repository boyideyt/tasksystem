package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.TaskDao;
import com.talenco.tasksystem.entity.Task;
import com.talenco.tasksystem.entity.User;
import com.talenco.tasksystem.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskDao taskDao;

    @Override
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    public Task getOne(Long taskId) {
        return taskDao.getOne(taskId);
    }

    @Override
    public void insert(Task task) {
        taskDao.insert(task);
    }

    @Override
    public void update(Task task) {
        taskDao.update(task);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            taskDao.delete(id);
        }
    }

    @Override
    public List<Task> searchByProjectName(String projectName) {
        return taskDao.searchByProjectName(projectName);
    }

    @Override
    public List<Task> searchByUsername(String username) {
        return taskDao.searchByUsername(username);
    }
}
