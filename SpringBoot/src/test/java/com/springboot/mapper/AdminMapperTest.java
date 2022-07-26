package com.springboot.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.ApplicationTests;
import com.springboot.entity.Admin;
import com.springboot.entity.Manager;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

class AdminMapperTest extends ApplicationTests {

    @Resource
    private AdminMapper adminMapper;

    @Test
    void adminFindAll() {
        List<Admin> list = adminMapper.AdminFindAll();
        for (Admin admin : list) {
            System.out.println(admin);
        }
    }

    @Test
    public void findByPage(){
        //执行分页
        PageHelper.startPage(1,5);
        //执行查询
        List<Admin> list = adminMapper.AdminFindAll();
        //封装PageInfo对象
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        //输出
        for (Admin admin : pageInfo.getList()) {
            System.out.println(admin);
        }

    }
}