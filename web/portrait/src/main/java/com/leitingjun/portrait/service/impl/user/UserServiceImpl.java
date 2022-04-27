package com.leitingjun.portrait.service.impl.user;

import com.leitingjun.portrait.domain.po.user.User;
import com.leitingjun.portrait.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
