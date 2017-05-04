package Servlets;

import jsf.AdminLoginBean;

import javax.faces.bean.ManagedProperty;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/admin/*")
public class AdminPanelFilter implements Filter {

    @ManagedProperty(value = "#{loginBean}")
    private AdminLoginBean adminLoginBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (adminLoginBean.isLogin()){
            chain.doFilter(request, response);
        }
        else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("adminLogin.xhtml");
        }
    }

    @Override
    public void destroy() {

    }
}
