package com.talenco.tasksystem.service;

import com.talenco.tasksystem.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getOne(String username);

    void insert(User user);

    void update(User user);

    void delete(Long[] ids);


}
