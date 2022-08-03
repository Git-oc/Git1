package servletProject.servlet.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/ctxController")
public class ServletContextController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1，通过this.getServletCon();
        ServletContext servletContext = this.getServletContext();
        //2，通过request对象获取
        ServletContext servletContext1 = req.getServletContext();
//        //3，通过session对象获取
//        HttpSession session = req.getSession();
//        ServletContext servletContext2 = session.getServletContext();

        //获取当前项目在服务器发布的真实路径
        System.out.println(servletContext.getRealPath("/"));
        //获取项目上下文路径
        System.out.println(servletContext.getContextPath());

        //存储数据
        servletContext.setAttribute("context","info");
    }
}
