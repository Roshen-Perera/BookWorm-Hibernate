package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AdminDTO;

import java.io.IOException;

public interface UserBO extends SuperBO {
    public boolean saveUser(AdminDTO dto) throws Exception;

    public String generateNewUserID() throws IOException;

    public boolean checkPassword(String username, String password) throws IOException;

}
