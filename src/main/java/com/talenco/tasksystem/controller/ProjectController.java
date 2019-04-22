package com.talenco.tasksystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.tasksystem.entity.Project;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/ProjectController")
public class ProjectController {


    @Autowired
    private ProjectService projectService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<Project> getAll() {

        return (List<Project>) JSONObject.toJSON(this.projectService.getAll());

    }


    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(Long projectId) {
        Project project= projectService.getOne(projectId);
        return JSONObject.toJSONString(project);
    }


    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody Project project) {
        try {
            System.out.println("insert"+project);
            projectService.insert(project);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Project project) {
        try {
            System.out.println("update"+project);
            projectService.update(project);
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
            projectService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
