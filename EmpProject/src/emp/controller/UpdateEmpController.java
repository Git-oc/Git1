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

@WebServlet(value = "/manager/safe/updateEmpController")
public class UpdateEmpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Double salary = Double.valueOf(req.getParameter("salary"));
        Integer age = Integer.valueOf(req.getParameter("age"));

        Emp emp = new Emp(id, name, salary, age);

        EmpService empService = new EmpServiceImpl();
        empService.modify(emp);

        resp.sendRedirect(req.getContextPath() + "/manager/safe/showAllEmpController");
    }
}
