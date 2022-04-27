package com.leitingjun.portrait.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Autowired
    private ShiroRealm shiroRealm;
    @Bean
    public SecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setAuthenticator();
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        Subject subject = SecurityUtils.getSubject();

        securityManager.setAuthorizer();
        securityManager.setRealm(shiroRealm);
    }
}
