package lk.ijse.dao;

import lk.ijse.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
