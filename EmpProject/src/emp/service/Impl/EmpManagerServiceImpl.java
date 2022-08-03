package emp.service.Impl;

import emp.dao.EmpManagerDao;
import emp.dao.Impl.EmpManargeDaoImpl;
import emp.entity.EmpManager;
import emp.service.EmpManagerService;
import emp.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManargeDaoImpl();

    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager = null;
        try {
            DbUtils.begin();
            EmpManager temp = empManagerDao.select(username);
            if (temp != null) {
                if (temp.getPassword().equals(password)) {
                    empManager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            throw new RuntimeException(e);
        }
        return empManager;
    }
}
