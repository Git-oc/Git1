package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(value = "/get")
public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取所有的Cookie
        Cookie[] cookies = req.getCookies();
        //通过循环遍历Cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(URLDecoder.decode(cookie.getName(), "UTF-8") + ":" + URLDecoder.decode(cookie.getValue(), "UTF-8"));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
