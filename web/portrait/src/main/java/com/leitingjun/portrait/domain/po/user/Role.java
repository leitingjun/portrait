package com.leitingjun.portrait.domain.po.user;

import java.util.List;

/**
 * @Author
 * @Date 2022/5/2 16:41
 **/

public class Role {
    private Integer id;
    private String value;

    //定义权限的集合
    private List<Permission> perms;

    public List<Permission> getPerms() {
        return perms;
    }

    public void setPerms(List<Permission> perms) {
        this.perms = perms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
