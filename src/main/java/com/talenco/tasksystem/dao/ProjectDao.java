package com.talenco.tasksystem.dao;


import com.talenco.tasksystem.entity.Project;

import java.util.List;


public interface ProjectDao {

    List<Project> getAll();

    Project getOne(Long projectId);

    int insert(Project project);

    void update(Project project);

    void delete(Long projectId);
}
