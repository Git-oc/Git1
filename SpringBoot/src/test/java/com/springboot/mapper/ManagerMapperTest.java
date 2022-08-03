package com.springboot.mapper;

import com.springboot.ApplicationTests;
import com.springboot.entity.Manager;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

class ManagerMapperTest extends ApplicationTests {

    @Resource
    private ManagerMapper managerMapper;

    @Test
    void managerFindAll() {
        List<Manager> list = managerMapper.ManagerFindAll();
        for (Manager manager:list) {
            System.out.println(manager);
        }
    }
}