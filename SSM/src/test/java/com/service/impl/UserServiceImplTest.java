package com.service.impl;

import com.bean.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring-context.xml", "classpath:Spring-mvc.xml", "classpath:Spring-Mybatis.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void checkLogin() {
        User user = userService.checkLogin("xiaming", "123123");
        assertNotNull(user);
    }
}