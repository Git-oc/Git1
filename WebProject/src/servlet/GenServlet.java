package servlet;

import javax.servlet.*;
import java.io.IOException;

public class GenServlet extends GenericServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("GenericServlet init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("你好，GenericServlet");
    }
}
