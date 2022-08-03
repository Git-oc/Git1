package conter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/counterController")
public class CounterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = req.getServletContext();

        //获取计数器
        Integer counter = (Integer) servletContext.getAttribute("counter");

        if (counter == null) {
            counter = 1;
            servletContext.setAttribute("counter", counter);
        } else {
            counter++;
            servletContext.setAttribute("counter", counter);
        }
        System.out.println("counter" + counter);
    }
}
