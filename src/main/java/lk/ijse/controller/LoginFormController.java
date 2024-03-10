package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private AnchorPane rootNode;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void clearFields(){
        txtUserName.clear();
        txtPassword.clear();
    }

    @FXML
    void btnForgotPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        boolean login = userBO.checkPassword(username, password);
        if(username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Empty").show();
            return;
        }
        if (login) {
            new Alert(Alert.AlertType.CONFIRMATION, "Logged in Successfully");
        } else {
            new Alert(Alert.AlertType.ERROR, "oops! credentials are incorrect!").show();
            clearFields();
        }
    }

    @FXML
    void btnSignUpFormOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/register_form.fxml"));
        Scene scene =new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("BookWorm");
        stage.setResizable(false);
        stage.show();
    }
}
