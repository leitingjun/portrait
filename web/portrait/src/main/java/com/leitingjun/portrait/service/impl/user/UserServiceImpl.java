package com.leitingjun.portrait.service.impl.user;

import com.leitingjun.portrait.domain.po.user.Role;
import com.leitingjun.portrait.domain.po.user.User;
import com.leitingjun.portrait.mapper.UserMapper;
import com.leitingjun.portrait.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Set<Role> findRoles(String username) {
        User user = userMapper.findRolesByUserName(username);
        return new HashSet<>(user.getRoles());
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
