package emp.dao.Impl;

import emp.dao.EmpManagerDao;
import emp.entity.EmpManager;
import emp.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManargeDaoImpl implements EmpManagerDao {
    QueryRunner queryRunner = new QueryRunner();

    @Override
    public EmpManager select(String username) {
        try {
            EmpManager empManager = queryRunner.query(DbUtils.getConnection(), "select * from empmanager where username=?;", new BeanHandler<>(EmpManager.class), username);
            return empManager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
