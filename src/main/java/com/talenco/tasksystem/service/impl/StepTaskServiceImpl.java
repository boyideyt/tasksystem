package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.StepTaskDao;
import com.talenco.tasksystem.entity.Step;
import com.talenco.tasksystem.entity.StepTask;
import com.talenco.tasksystem.service.StepTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StepTaskServiceImpl implements StepTaskService {


    @Resource
    private StepTaskDao stepTaskDao;

    @Override
    public List<StepTask> getAll() {
        return stepTaskDao.getAll();
    }

    @Override
    public StepTask getOne(Long id) {
        return stepTaskDao.getOne(id);
    }

    @Override
    public void insert(List<Step> steps,Long taskId) {
        StepTask stepTask = new StepTask();
        stepTask.setTaskId(taskId);
        for (Step step:steps) {
            stepTask.setStepId(step.getStepId());
            stepTask.setStepName(step.getStepName());
            stepTask.setStepIndex(step.getStepIndex());
            stepTaskDao.insert(stepTask);
        }
    }

    @Override
    public void update(StepTask stepTask) {
        stepTaskDao.update(stepTask);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            stepTaskDao.delete(id);
        }
    }

    @Override
    public List<StepTask> searchByTaskId(Long taskId) {
        return stepTaskDao.searchByTaskId(taskId);
    }

    @Override
    public List<StepTask> searchByUsername(String username) {
        return stepTaskDao.searchByUsername(username);
    }
}
