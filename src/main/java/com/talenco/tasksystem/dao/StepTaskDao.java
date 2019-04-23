package com.talenco.tasksystem.dao;


import com.talenco.tasksystem.entity.StepTask;

import java.util.List;


public interface StepTaskDao {

    List<StepTask> getAll();

    StepTask getOne(Long id);

    void insert(StepTask stepTask);

    void update(StepTask stepTask);

    void delete(Long id);

    List<StepTask> searchByTaskId(Long taskId);

    List<StepTask> searchByUsername(String username);
}
