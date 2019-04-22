package com.talenco.tasksystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.tasksystem.entity.Project;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.Task;
import com.talenco.tasksystem.entity.User;
import com.talenco.tasksystem.service.TaskService;
import com.talenco.tasksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/TaskController")
public class TaskController {


    @Autowired
    private TaskService taskService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<Task> getAll() {
        return (List<Task>) JSONObject.toJSON(this.taskService.getAll());
    }

    @RequestMapping("/searchByUsername")
    @ResponseBody
    public List<Task> searchByUsername(String username) {
        return (List<Task>) JSONObject.toJSON(this.taskService.searchByUsername(username));
    }


    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(Long taskId) {
        Task task= taskService.getOne(taskId);
        return JSONObject.toJSONString(task);
    }

    @RequestMapping("/searchByProjectName")
    @ResponseBody
    public String searchByProjectName(String projectName) {
        List<Task> list= taskService.searchByProjectName(projectName);
        return JSONObject.toJSONString(list);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody Task task) {
        try {
            System.out.println(task);
            taskService.insert(task);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Task task) {
        try {
            taskService.update(task);
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
            taskService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
