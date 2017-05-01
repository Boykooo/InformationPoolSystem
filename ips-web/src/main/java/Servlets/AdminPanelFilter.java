package Servlets;

import jsf.LoginBean;

import javax.faces.bean.ManagedProperty;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminPanelFilter implements Filter {

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (loginBean.isLogin()){
            chain.doFilter(request, response);
        }
        else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("loginToAdminPanel.xhtml");
        }
    }

    @Override
    public void destroy() {

    }
}
