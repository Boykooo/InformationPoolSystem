import Entities.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       UserDao userDao = new UserDao();
       User user = userDao.findById(1);

       req.setAttribute("name", user.getFirstName());

       req.getRequestDispatcher("startPage.jsp").forward(req, resp);
    }
}
