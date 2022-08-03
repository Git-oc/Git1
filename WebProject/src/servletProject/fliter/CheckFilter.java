package servletProject.fliter;

import servletProject.entity.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/showallcontroller")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //权限验证，验证管理员是否登入（向下转型、拆箱）
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Manager mgr = (Manager) session.getAttribute("mgr");
        if (mgr != null) { //登录过
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "loginMgr.html");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
