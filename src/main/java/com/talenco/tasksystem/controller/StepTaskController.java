package com.talenco.tasksystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.StepTask;
import com.talenco.tasksystem.service.StepTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/StepTaskController")
public class StepTaskController {


    @Autowired
    private StepTaskService stepTaskService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<StepTask> getAll() {
        return (List<StepTask>) JSONObject.toJSON(this.stepTaskService.getAll());
    }

    @RequestMapping("/searchByUsername")
    @ResponseBody
    public List<StepTask> searchByUsername(String username) {
        return (List<StepTask>) JSONObject.toJSON(this.stepTaskService.searchByUsername(username));
    }


    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(Long stepTaskId) {
        StepTask stepTask= stepTaskService.getOne(stepTaskId);
        return JSONObject.toJSONString(stepTask);
    }

    @RequestMapping("/searchByTaskId")
    @ResponseBody
    public String searchByTaskId(Long taskId) {
        return JSONObject.toJSONString(stepTaskService.searchByTaskId(taskId));
    }


    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody StepTask stepTask) {
        try {
            stepTaskService.update(stepTask);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Long[] ids) {
        try {
            stepTaskService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
