package Servlets;

import Entities.Session;
import Entities.User;
import services.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UserPageServlet extends HttpServlet {


    @EJB
    private UserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        refreshPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("deleteButton") != null){
            doDelete(req, resp);
            return;
        }

        if (req.getParameter("updateButton") != null){
            doPut(req, resp);
            return;
        }
        service.insert(createUser(req));
        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.update(createUser(req));
        refreshPage(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        service.delete(email);
        refreshPage(req, resp);
    }

    private void refreshPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> usersList = service.findAll();
        req.setAttribute("users", usersList);
        req.getRequestDispatcher("pages/usersPage.jsp").forward(req, resp);
    }

    private User createUser(HttpServletRequest req){
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setPassword(password);
        newUser.setSessionsList(new ArrayList<Session>());

        return newUser;
    }
}
