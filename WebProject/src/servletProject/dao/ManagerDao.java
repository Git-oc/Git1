package servletProject.dao;

import servletProject.entity.Manager;

public interface ManagerDao {
    public Manager select(String username);
}
