package com.service.impl;

import com.dao.UserDAO;
import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public List<User> listUsers() {
        return userDAO.queryUsers();
    }
}
