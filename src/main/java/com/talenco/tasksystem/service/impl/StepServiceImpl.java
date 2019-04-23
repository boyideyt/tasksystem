package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.StepDao;
import com.talenco.tasksystem.entity.Step;
import com.talenco.tasksystem.service.StepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    @Resource
    private StepDao stepDao;

    @Override
    public List<Step> getAll() {
        return stepDao.getAll();
    }

    @Override
    public Step getOne(Long stepId) {
        return stepDao.getOne(stepId);
    }

    @Override
    public void insert(Step step) {
        stepDao.insert(step);
    }

    @Override
    public void update(Step step) {
        stepDao.update(step);
    }


    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            stepDao.delete(id);
        }
    }

    @Override
    public List<Step> searchByProjectId(Long projectId) {
        return stepDao.searchByProjectId(projectId);
    }

    @Override
    public List<Step> searchByCheckMan(String username) {
        return stepDao.searchByCheckMan(username);
    }
}
