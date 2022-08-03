package com.dao;

import com.pojo.User;

public interface UserDAO {
    public int insertUser(User user);

    //根据用户名查询用户信息
    public User queryUser(String username);

}
