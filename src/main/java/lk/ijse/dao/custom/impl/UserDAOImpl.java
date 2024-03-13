package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public String generateNewID() throws IOException {
        return null;
    }

    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(User entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(User entity) throws Exception {
        return false;
    }

    @Override
    public boolean exist(String id) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public User search(String id) throws SQLException {
        return null;
    }
}
