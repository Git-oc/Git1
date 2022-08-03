package servletProject.service.impl;

import servletProject.dao.ManagerDao;
import servletProject.dao.impl.ManagerDaoImpl;
import servletProject.entity.Manager;
import servletProject.service.ManagerServlet;
import servletProject.utils.DbUtils;

public class ManagersServletImpl implements ManagerServlet {
    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public Manager login(String username, String password) {
        Manager manager = null;
        try {
            DbUtils.begin();
            Manager temp = managerDao.select(username);
            if (temp != null) {
                if (temp.getPassword().equals(password)) {
                    manager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return manager;
    }
}
