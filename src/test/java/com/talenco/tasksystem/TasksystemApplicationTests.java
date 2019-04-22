package com.talenco.tasksystem;


import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksystemApplicationTests {

    @Test
    public void contextLoads() {
        String[] myList = {"lizhe","liao","songzhilin","linyicheng","wangzhe","wanghaocong","zhuyingying","zhaogeng","guoxinghui"};
        int size = myList.length;
        for (int i = 0; i < 5; i++) {
            double num = Math.random()*size;

        }
    }

    @Test
    public void maoTest() {
        HashMap<Long, String> hashMap = new HashMap<>();
        hashMap.put(1L,"大纲");
        //["大纲","实验手册","ppt","讲稿","试题","视频","官方文档材料"]
    }

    @Test
    public void arrayTest() {
        ArrayList<String> strings = new ArrayList<>(7);
        strings.add("大纲");
        strings.add("实验手册");
        strings.add("ppt");
        strings.add("讲稿");
        strings.add("试题");
        strings.add("视频");
        strings.add("官方文档材料");
        Object json = JSONObject.toJSON(strings);
        System.out.println(json);
        ArrayList<Integer> ints = new ArrayList<>(7);
        ints.add(2);
        ints.add(1);
        ints.add(1);
        ints.add(0);
        ints.add(0);
        ints.add(0);
        ints.add(0);
        Object ob = JSONObject.toJSON(ints);
        System.out.println(ob);
    }

}

