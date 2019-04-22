package com.talenco.tasksystem.dao;


import com.talenco.tasksystem.entity.User;

import java.util.List;


public interface UserDao {

    List<User> getAll();

    User getOne(String userName);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
