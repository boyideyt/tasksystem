package com.talenco.tasksystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.talenco.tasksystem.dao.ProjectDao;
import com.talenco.tasksystem.dao.UserDao;
import com.talenco.tasksystem.entity.Project;
import com.talenco.tasksystem.entity.User;
import com.talenco.tasksystem.service.ProjectService;
import com.talenco.tasksystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public void insert(Project project) {
        //根据步骤,计算步骤数
        JSONArray projectStepList = JSON.parseArray(project.getProjectStepList());
        Long size = Long.valueOf(projectStepList.size());
        project.setProjectStepNum(size);
        projectDao.insert(project);
    }

    @Override
    public void update(Project project) {
        projectDao.update(project);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long projectId:ids) {
            projectDao.delete(projectId);
        }
    }
}
