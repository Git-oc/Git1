package com.springboot.mapper;

import com.springboot.entity.Manager;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ManagerMapper {

    /*MyBatis注解（增，删，查，改）：
     * @Select  查
     * @Insert  增
     * @Delete  删
     * @Update  改
     */
    @Select("select * from manager")
    List<Manager> ManagerFindAll();

}
