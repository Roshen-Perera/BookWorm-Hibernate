package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NavigationFormController {
    @FXML
    private AnchorPane rootHome;

    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }

    @FXML
    void btnManageBooksOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }

    @FXML
    void btnManageBranchesOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }

    @FXML
    void btnManageMembersOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }

    @FXML
    void btnManageTransactionsOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }

    @FXML
    void btnManageUsersOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.rootHome.getChildren().clear();
        this.rootHome.getChildren().add(rootNode);
    }
}
