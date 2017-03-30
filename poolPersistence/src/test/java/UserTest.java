import Entities.User;
import dao.UserDao;
import junit.framework.TestCase;

public class UserTest extends TestCase{

    public void testPrintUser(){
        UserDao dao = new UserDao();
        User user = dao.findById("test@test.com");

        System.out.printf(String.valueOf(user.getSessionsList().size()));
    }

    public void testEmptySessionList(){

        UserDao dao = new UserDao();
        User user = dao.findById("test@test.com");

        user.setSessionsList(null);

        dao.update(user);

    }
}
