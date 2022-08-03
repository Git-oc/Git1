package com.dao;

import com.bean.User;

public interface UserDAO {

    public User queryUserByName(String name);

}
