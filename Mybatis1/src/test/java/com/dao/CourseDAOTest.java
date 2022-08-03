package com.dao;

import com.pojo.Course;
import com.utils.MyBatisUtil;
import org.junit.Test;

public class CourseDAOTest {

    @Test
    public void testQueryCourseById() {
        CourseDAO courseDAO = MyBatisUtil.getMapper(CourseDAO.class);
        Course course = courseDAO.queryCourseById(1);
        System.out.println(course);
    }
}