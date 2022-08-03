package com.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Student;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentDAOTest {

    @Test   //增
    public void insertStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(false);//手动提交事务
        //1，当获取sqlSession对象时，默认开启事务
        try {
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            //测试StudentDAO中的方法
            Student student = new Student(0, "1004", "luck", "男", 20);
            int i = studentDAO.insertStudent(student);
            System.out.println(student);
            //2，操作完成后需要手动提交
            sqlSession.commit();
            System.out.println(i);
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    @Test   //删
    public void deleteStudent() {
        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        //调用被测试方法
        int i = studentDAO.deleteStudent("1004");
        //提交事务
        //sqlSession.commit();
        System.out.println(i);
    }

    @Test   //改
    public void updateStudent() {
        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        //测试StudentDAO中的方法
        int i = studentDAO.updateStudent(new Student(0, "1001", "夏明", "女", 18));
        //sqlSession.commit();
        assertEquals(1, i);
    }

    @Test   //查 所有
    public void ListStudent() {
        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        List<Student> list = studentDAO.listStudents();
        for (Student stu : list) {
            System.out.println(stu);
        }
        assertNotNull(list);
    }

    @Test   //查一个记录
    public void QueryStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
        //通过会话获取DAO对象
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        //测试StudentDAO中的方法
        Student student = studentDAO.queryStudent("1001");
        System.out.println(student);
    }

    @Test
    public void ListStudentByPage() {
        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        PageHelper.startPage(1, 3);
        List<Student> students = studentDAO.listStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        List<Student> list = pageInfo.getList();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
}