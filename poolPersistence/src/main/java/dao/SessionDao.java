package dao;

import Entities.Session;
import Entities.SessionPK;

import javax.ejb.Stateless;

@Stateless
public class SessionDao extends GenericDaoImpl<Session, SessionPK> {
    public SessionDao() {
        super(Session.class);
    }
}
