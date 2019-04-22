//package com.talenco.tasksystem.service.impl;
//
//import com.talenco.tasksystem.dao.UserDao;
//import com.talenco.tasksystem.entity.User;
//import com.talenco.tasksystem.security.MyUserDetails;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//
//@Service
//public class MyUserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.getOne(username);
//        if (user == null) {
//        throw new UsernameNotFoundException("username " + username + " not found");
//        }
//
//        return new MyUserDetails(user);
//
//    }
//}
//
