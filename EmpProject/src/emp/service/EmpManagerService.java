package emp.service;

import emp.entity.EmpManager;

public interface EmpManagerService {
    public EmpManager login(String username, String password);
}
