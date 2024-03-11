package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    public boolean saveUser(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getId(), dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getRepeatpassword()));
    }

    public String generateNewUserID() throws IOException{
        return userDAO.generateNewID();
    }

    public boolean checkPassword(String username, String password) throws IOException{
        return userDAO.checkPassword(username, password);
    }
}
