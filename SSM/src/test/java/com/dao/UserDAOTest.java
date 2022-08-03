package com.dao;

import com.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring-context.xml", "classpath:Spring-mvc.xml", "classpath:Spring-Mybatis.xml"})
public class UserDAOTest {

    @Resource
    private UserDAO userDAO;

    @Test
    public void queryUserByName() {
        User user = userDAO.queryUserByName("xiaming");
        System.out.println(user);
    }
}