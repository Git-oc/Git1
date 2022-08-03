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

@WebServlet(value = "/manager/safe/showEmpController")
public class ShowEmpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.showEmp(id);

        req.setAttribute("emp", emp);

        req.getRequestDispatcher("/manager/safe/showUpdateEmpInfoJSP").forward(req, resp);
    }
}
