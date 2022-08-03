package servlet2;

import servlet.HttpsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*使用注解：
 * 1，value = {"/xxx"}        配置url路径，可配多个
 * 2,urlPatterns = {"/xxx"}  配置url路径，可配多个
 * 3,loadOnStartup           配置Servlet创建的时机
 * */

@WebServlet(value = {"/bs"}, loadOnStartup = 0)
public class BasicServlet extends HttpsServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是Post");
    }
}
