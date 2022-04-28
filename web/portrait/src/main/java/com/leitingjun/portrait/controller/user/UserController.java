package com.leitingjun.portrait.controller.user;

import com.leitingjun.portrait.domain.po.user.User;
import com.leitingjun.portrait.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<User> login(String username,String password){
        User user = userService.findByUsername(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        token.setRememberMe(true);
        try {
            subject.login(token);
        }catch (UnauthorizedException unauthorizedException){

        }catch (UnauthenticatedException unauthenticatedException){

        }catch (Exception e){

        }
        ResponseEntity<User> response = ResponseEntity.ok(user);
        return response;
    }
}
