package emp.service.Impl;

import emp.dao.EmpDao;
import emp.dao.Impl.EmpDaoIpml;
import emp.entity.Emp;
import emp.service.EmpService;
import emp.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoIpml();

    @Override
    public List<Emp> showAllEmp() {
        List<Emp> emps = new ArrayList<>();
        try {
            DbUtils.begin();
            List<Emp> temps = empDao.selectAll();
            if (temps != null) {
                emps = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            throw new RuntimeException(e);
        }
        return emps;
    }

    @Override
    public int removeEmp(int id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(Emp emp) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emp showEmp(int id) {
        Emp emp = null;
        try {
            DbUtils.begin();
            emp = empDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }
}
