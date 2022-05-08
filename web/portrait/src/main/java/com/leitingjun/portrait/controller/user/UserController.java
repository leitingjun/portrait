package com.leitingjun.portrait.controller.user;

import com.leitingjun.portrait.anno.ParameterLogger;
import com.leitingjun.portrait.domain.po.user.User;
import com.leitingjun.portrait.service.UserService;
import io.swagger.annotations.*;
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
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;

@RestController
@Api(tags = "用户")
@RequestMapping("/user")
@ParameterLogger
public class UserController {
    private Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "username",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)})
    public ResponseEntity<User> login(String username,String password){
        User user = userService.findByUsername(username);
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        token.setRememberMe(true);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

        }catch (UnauthorizedException unauthorizedException){

        }catch (UnauthenticatedException unauthenticatedException){

        }catch (Exception e){

        }
        ResponseEntity<User> response = ResponseEntity.ok(user);
        return response;
    }

    @PostMapping("register")
    public String register(String phone){
        return "ok";
    }
}
