package servletProject.service;

import servletProject.entity.Manager;

public interface ManagerServlet {
    public Manager login(String username, String password);
}
