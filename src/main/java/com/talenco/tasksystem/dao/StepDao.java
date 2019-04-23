package com.talenco.tasksystem.dao;


import com.talenco.tasksystem.entity.Step;

import java.util.List;


public interface StepDao {

    List<Step> getAll();

    Step getOne(Long id);

    void insert(Step step);

    void update(Step step);

    void delete(Long id);

    List<Step> searchByProjectId(Long projectId);

    List<Step> searchByCheckMan(String checkMan);
}
