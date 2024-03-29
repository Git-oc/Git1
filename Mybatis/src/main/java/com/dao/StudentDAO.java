package com.dao;

import com.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDAO {
    public int insertStudent(Student student);

    public int deleteStudent(String stuNum);

    public int updateStudent(Student student);

    public List<Student> listStudents();

    public Student queryStudent(String stuNam);

}
