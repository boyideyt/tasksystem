//package com.talenco.tasksystem.security;
//
//
//import com.talenco.tasksystem.service.impl.MyUserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
//public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    @Qualifier("MyUserDetailsServiceImpl")
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login.html")      // 设置登录页面
//                .loginProcessingUrl("/UserController/login") // 自定义的登录接口
//                .and()
//                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/login.html").permitAll()   // 设置所有人都可以访问登录页面
//                .anyRequest()        // 任何请求,登录后可以访问
//                .authenticated()
//                .and()
//                .csrf().disable();     // 关闭csrf防护
//    }
//
//
//}
