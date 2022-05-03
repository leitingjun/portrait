package com.leitingjun.portrait.mapper;

import com.leitingjun.portrait.domain.po.user.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //根据用户名查询所有角色
    User findRolesByUserName(String username);
}
