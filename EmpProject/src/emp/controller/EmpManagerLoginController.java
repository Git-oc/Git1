package emp.controller;

import emp.entity.EmpManager;
import emp.service.EmpManagerService;
import emp.service.Impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/manager/EmpManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");
        //效验验证码
        String codes = (String) req.getSession().getAttribute("codes");
        if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            //调用业务逻辑
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username, password);
            if (empManager != null) {
                HttpSession session = req.getSession();
                session.setAttribute("empManager", empManager);

                resp.sendRedirect(req.getContextPath() + "/manager/safe/showAllEmpController");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login.html");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
}
