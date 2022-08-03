package emp.controller;

import emp.service.EmpService;
import emp.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/manager/safe/removeEmpController")
public class RemoveEmpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        EmpService empService = new EmpServiceImpl();

        empService.removeEmp(id);

        resp.sendRedirect(req.getContextPath() + "/manager/safe/showAllEmpController");
    }
}
