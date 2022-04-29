package com.leitingjun.portrait.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Autowired
    private ShiroRealm shiroRealm;
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        securityManager.setAuthenticator(authenticator);

        securityManager.setRealm(shiroRealm);
        return securityManager;
    }
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //cas验证登录
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/user/register", "anon");

        //filterChainDefinitionMap.put("/test/a", "anon");
        filterChainDefinitionMap.put("/code/getCode", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger**/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");

        // 添加自己的过滤器并且取名为jwt
//        Map<String, Filter> filterMap = new LinkedHashMap<String, Filter>(1);
        //如果cloudServer为空 则说明是单体 需要加载跨域配置
//        filterMap.put("jwt", new JwtFilter(true));
//        shiroFilterFactoryBean.setFilters(filterMap);
        // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
//        filterChainDefinitionMap.put("/**", "jwt");

        // 未授权界面返回JSON
        //shiroFilterFactoryBean.setUnauthorizedUrl("/sys/common/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}
