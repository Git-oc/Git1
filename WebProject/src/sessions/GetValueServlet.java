package sessions;

import servlet.HttpsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/getValue")
public class GetValueServlet extends HttpsServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request获取session对象
        HttpSession session = req.getSession();

        String s = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");


        System.out.println("从session中获得了：" + s);
        System.out.println("从request中获得了：" + password);
    }
}
