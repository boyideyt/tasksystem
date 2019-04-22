//package com.talenco.tasksystem.security;
//
//import com.talenco.tasksystem.entity.User;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class MyUserDetails implements UserDetails {
//
//    private User user;
//
//    // 封装了权限信息
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    // 密码信息
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//    // 帐户是否过期
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    // 帐户密码是否过期，一般有的密码要求性高的系统会使用到，比较每隔一段时间就要求用户重置密码
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
