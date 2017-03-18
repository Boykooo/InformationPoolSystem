import Entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService service = new UserService();

        User user = service.findById(18);

        if (user != null) {
            req.setAttribute("name", user.getFirstName());
        }

        req.getRequestDispatcher("startPage.jsp").forward(req, resp);
    }
}
