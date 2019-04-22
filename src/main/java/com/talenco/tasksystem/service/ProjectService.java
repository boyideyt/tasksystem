package com.talenco.tasksystem.service;


import com.talenco.tasksystem.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAll();

    Project getOne(Long id);

    void insert(Project project);

    void update(Project project);

    void delete(Long[] ids);
}
