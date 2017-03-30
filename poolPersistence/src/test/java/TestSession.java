import Entities.Session;
import Entities.Track;
import Entities.User;
import dao.SessionDao;
import dao.TrackDao;
import dao.UserDao;
import junit.framework.TestCase;

import java.sql.Timestamp;

public class TestSession extends TestCase {

    public void testInsertSession(){
        SessionDao sessionDao = new SessionDao();

        Session session = new Session();
        session.setSessionTime(Timestamp.valueOf("2004-10-19 10:23:54"));
        session.setCost(250);
        //session.setTrackId(1);

        TrackDao trackDao = new TrackDao();
        Track track = trackDao.findById(1);
        session.setTrack(track);

        UserDao userDao = new UserDao();
        User user = userDao.findById("test@test.com");

        session.setUser(user);

        sessionDao.insert(session);

//        INSERT INTO ips.session(
//                "time","cost", "user_email", "track_id")
//        VALUES ('2004-10-19 10:23:54', 250, 'test@test.com', '1');
    }
}
