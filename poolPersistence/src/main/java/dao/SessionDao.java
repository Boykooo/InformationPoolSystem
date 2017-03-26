package dao;

import Entities.Session;

import javax.ejb.Stateless;
import java.sql.Timestamp;

@Stateless
public class SessionDao extends GenericDaoImpl<Session, Timestamp> {
    public SessionDao() {
        super(Session.class);
    }
}
