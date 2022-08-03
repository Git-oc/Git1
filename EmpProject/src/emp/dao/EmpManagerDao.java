package emp.dao;

import emp.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username);
}
