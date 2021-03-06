package com.talenco.tasksystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.User;
import com.talenco.tasksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/UserController")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll() {
        return (List<User>) JSONObject.toJSON(this.userService.getAll());
    }

    @RequestMapping("/getManager")
    @ResponseBody
    public List<User> getManager() {
        return (List<User>) JSONObject.toJSON(this.userService.getManager());
    }


    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(String username) {
        User u= userService.getOne(username);
        return JSONObject.toJSONString(u);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody User user) {
        try {
            userService.insert(user);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user) {
        try {
            userService.update(user);
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
            userService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    @RequestMapping("/login")
    @ResponseBody
    public void login(@RequestBody User user) {
        System.out.println(user);
    }

    @RequestMapping("/name")
    @ResponseBody
    public Map name() {
        System.out.println();

        Map map = new HashMap();
        map.put("loginName", 0);
        return map;
    }
}
