package Servlets;

import Entities.Pool;
import services.PoolService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pools")
public class PoolPageServlet extends HttpServlet {

    @EJB
    PoolService poolService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pool> pools = poolService.findAll();

        req.setAttribute("pools", pools);
        req.getRequestDispatcher("pages/poolsPage.jsp").forward(req, resp);
    }
}
