package dao;

import Entities.Session;

import java.sql.Timestamp;

public class SessionDao extends GenericDaoImpl<Session, Timestamp> {

    public SessionDao() {
        super(Session.class);
    }
}
