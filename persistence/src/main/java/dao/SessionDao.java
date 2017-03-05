package dao;

import Entities.Session;

import javax.persistence.EntityManager;
import java.sql.Timestamp;

public class SessionDao extends GenericDaoImpl<Session, Timestamp> {

    public SessionDao(EntityManager manager) {
        super(manager, Session.class);
    }
}
