package com.dao;

import com.pojo.Class;
import com.utils.MyBatisUtil;
import org.junit.Test;

public class ClassDAOTest {

    @Test
    public void testQueryClass() {

        ClassDAO classDAO = MyBatisUtil.getMapper(ClassDAO.class);
        Class clazz = classDAO.queryClass(1);
        System.out.println(clazz);

    }
}