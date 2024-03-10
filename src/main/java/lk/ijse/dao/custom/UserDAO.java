package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.User;

import java.io.IOException;

public interface UserDAO extends SuperDAO{
    public String generateNewID() throws IOException;
    public boolean save(User entity) throws Exception;
    public boolean checkPassword(String username, String password) throws IOException;
}
