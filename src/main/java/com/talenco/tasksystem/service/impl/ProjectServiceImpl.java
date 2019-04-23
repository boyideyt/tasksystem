package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.ProjectDao;
import com.talenco.tasksystem.entity.Project;
import com.talenco.tasksystem.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDao projectDao;

    @Override
    public List<Project> getAll() {
        return projectDao.getAll();
    }

    @Override
    public Project getOne(Long projectId) {
        return projectDao.getOne(projectId);
    }

    @Override
    public Long insert(Project project) {
        projectDao.insert(project);
        return project.getProjectId();
    }

    @Override
    public void update(Project project) {
        projectDao.update(project);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long projectId : ids) {
            projectDao.delete(projectId);
        }
    }
}
