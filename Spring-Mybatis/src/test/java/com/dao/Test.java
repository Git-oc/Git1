package com.dao;

import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
public class Test {
    @org.junit.Test
    public void test1() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");

        List<User> users = userService.listUsers();
        System.out.println(users);

    }

    @org.junit.Test
    public void test2(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = new User(0,"xiaming","123123","夏明","04.jpg");
        int i = userDAO.insertUser(user);

        System.out.println(i);

    }
}