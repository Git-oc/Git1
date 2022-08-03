package sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ss")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取session对象
        HttpSession session = req.getSession();

        //使用session保存数据
        session.setAttribute("username", "oc");
        req.setAttribute("password", "123456");

        resp.sendRedirect("/WebProject_war_exploded/getValue");
        System.out.println(session.getId());
    }
}
