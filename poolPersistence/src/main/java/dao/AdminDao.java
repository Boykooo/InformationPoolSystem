package dao;

import Entities.Admin;

import javax.ejb.Stateless;

@Stateless
public class AdminDao extends GenericDaoImpl<Admin, String> {
    public AdminDao() {
        super(Admin.class);
    }
}
