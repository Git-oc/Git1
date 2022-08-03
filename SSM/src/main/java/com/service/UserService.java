package com.service;

import com.bean.User;

public interface UserService {

    public User checkLogin(String userName, String userPwd);

}
