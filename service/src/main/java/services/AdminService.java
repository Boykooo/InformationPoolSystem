package services;

import Entities.Admin;
import dao.AdminDao;
import dto.AdminDto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class AdminService implements IService<AdminDto, String> {

    @EJB
    private AdminDao dao;

    @Override
    public AdminDto findById(String key) {
        return convertToDto(dao.findById(key));
    }

    @Override
    public List<AdminDto> findAll() {
        List<AdminDto> adminsDto = new ArrayList<>();
        dao.findAll().forEach(
                (Admin admin) -> adminsDto.add(convertToDto(admin))
        );

        return adminsDto;
    }

    @Override
    public void insert(AdminDto adminDto)  {
//        if (dao.findById(adminDto.getUsername()) == null){
//            dao.insert(convertToEntity(adminDto));
//        }
//        else {
//            throw new ObjectAlreadyExistsException();
//        }
    }

    @Override
    public void update(AdminDto adminDto)  {
//        if (dao.findById(adminDto.getUsername()) != null){
//            dao.update(convertToEntity(adminDto));
//        }
//        else {
//            throw new UpdateObjectNotExistException();
//        }
    }

    @Override
    public boolean delete(String key) {
        if (dao.findById(key) != null){
            dao.delete(key);
            return true;
        }

        return false;
    }

    private AdminDto convertToDto(Admin entity){
        AdminDto dto = new AdminDto();
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());

        return dto;
    }
    private Admin convertToEntity(AdminDto dto){
       Admin admin = new Admin();
       admin.setUsername(dto.getUsername());
       admin.setPassword(dto.getPassword());

       return admin;
    }
}
