package servletProject.servlet.controller;

import servletProject.entity.Manager;
import servletProject.service.ManagerServlet;
import servletProject.service.impl.ManagersServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginMgr")
public class LoginMgrController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");

        String codes = (String) req.getSession().getAttribute("codes");
        if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            //调研业务方法
            ManagerServlet managerServlet = new ManagersServletImpl();
            Manager mgr = managerServlet.login(username, password);

            //处理结果，流程跳转
            if (mgr != null) {
                //登陆成功
                //将管理员信息存储到Session里
                HttpSession session = req.getSession();
                session.setAttribute("mgr", mgr);
                //跳转 目标、方式
                resp.sendRedirect("/WebProject_war_exploded/showallcontroller");
            } else {
                //登录失败
                resp.sendRedirect("/WebProject_war_exploded/loginMgr.html");
            }
        } else {
            resp.sendRedirect("/WebProject_war_exploded/loginMgr.html");
        }
    }
}
