package com.leitingjun.portrait.service;

import com.leitingjun.portrait.domain.po.user.User;

import java.util.Set;

public interface UserService {
    public void changePassword(Long userId, String newPassword); //修改密码
    public User findByUsername(String username); //根据用户名查找用户
    public Set<String> findRoles(String username);// 根据用户名查找其角色
    public Set<String> findPermissions(String username);// 根据用户名查找其权限
}
