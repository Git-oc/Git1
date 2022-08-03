package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> listStudentsByCid(int cid);
}
