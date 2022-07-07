package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDAO {
    public List<User> queryUsers();

    public int insertUser(User user);

}
