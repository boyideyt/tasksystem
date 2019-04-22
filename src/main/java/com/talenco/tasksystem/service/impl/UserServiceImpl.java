package com.talenco.tasksystem.service.impl;

import com.talenco.tasksystem.dao.UserDao;
import com.talenco.tasksystem.entity.User;
import com.talenco.tasksystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
        public User getOne(String user) {
        return userDao.getOne(user);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            userDao.delete(id);
        }
    }
}
