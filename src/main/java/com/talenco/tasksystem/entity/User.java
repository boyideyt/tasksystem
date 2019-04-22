package com.talenco.tasksystem.entity;
import lombok.*;

@Getter
@Setter
@ToString
public class User {

    private Long userId;        //id

    private String username;    //用户名

    private String realname;    //名字

    private String password;	//用户密码

    private Long role;			// 角色表


}
