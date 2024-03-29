package emp.controller;

import emp.entity.Emp;
import emp.service.EmpService;
import emp.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manager/safe/showAllEmpController")
public class ShowAllEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService = new EmpServiceImpl();
        List<Emp> emps = empService.showAllEmp();

        req.setAttribute("emps", emps);

        req.getRequestDispatcher("/manager/safe/showAllEmpJSP").forward(req, resp);
    }
}
