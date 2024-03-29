package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER, LOGIN, BRANCH, BOOK, TRANSACTION
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            case BOOK:
                return new BookDAOImpl();
            case TRANSACTION:
                return new TransactionDAOImpl();
            default:
                return null;
        }
    }
}
