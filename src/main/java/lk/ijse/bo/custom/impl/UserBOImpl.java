package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.entity.Admin;

import java.io.IOException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    public boolean saveUser(AdminDTO dto) throws Exception {
        return userDAO.save(new Admin(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getRepeatpassword()));
    }

    public String generateNewUserID() throws IOException{
        return userDAO.generateNewID();
    }

    public boolean checkPassword(String username, String password) throws IOException{
        return userDAO.checkPassword(username, password);
    }
}
