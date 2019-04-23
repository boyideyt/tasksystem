package com.talenco.tasksystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.Step;
import com.talenco.tasksystem.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/StepController")
public class StepController {


    @Autowired
    private StepService stepService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<Step> getAll() {
        return (List<Step>) JSONObject.toJSON(this.stepService.getAll());
    }

    @RequestMapping("/searchByUsername")
    @ResponseBody
    public List<Step> searchByUsername(String username) {
        return (List<Step>) JSONObject.toJSON(this.stepService.searchByCheckMan(username));
    }


    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(Long stepId) {
        Step step = stepService.getOne(stepId);
        return JSONObject.toJSONString(step);
    }

    @RequestMapping("/searchByProjectId")
    @ResponseBody
    public String searchByProjectId(Long projectId) {
        System.out.println("searchByProjectId"+projectId);
        List<Step> list = stepService.searchByProjectId(projectId);
        System.out.println(list);
        return JSONObject.toJSONString(list);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody List<Step> stepList) {
        try {
            for (int i=0;i<stepList.size();i++){
                Step step = stepList.get(i);
                step.setStepIndex((long) i);
                System.out.println("insert"+step);
                stepService.insert(step);
            }

            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody List<Step> stepList) {
        try {
            for (int i=0;i<stepList.size();i++) {
                stepService.update(stepList.get(i));
            }
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
            stepService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
