package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dto.BranchDTO;
import lk.ijse.dto.tm.BranchTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BranchesFormController {

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private Label lblBranchId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<BranchTM> tblBranch;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtSearch;
    BranchBO branchBO = (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BRANCH);
    public void initialize() throws Exception {
        generateNextUserId();
        loadAllBranches();
        setCellValueFactory();
        tableListener();
    }

    public void clearfield(){
        txtLocation.clear();
        txtMobile.clear();
        txtEmail.clear();
        txtSearch.clear();
    }

    private void generateNextUserId() throws SQLException, IOException, ClassNotFoundException {
        String nextId = branchBO.generateNewUserID();
        lblBranchId.setText(nextId);
    }

    private void loadAllBranches() throws Exception {
        ObservableList<BranchTM> obList = FXCollections.observableArrayList();
        try{
            List<BranchDTO> dtoList = branchBO.getAllBranches();

            for (BranchDTO dto : dtoList) {
                obList.add(
                        new BranchTM(
                                dto.getId(),
                                dto.getLocation(),
                                dto.getEmail(),
                                dto.getMobile()
                        )
                );
            }
            tblBranch.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void tableListener() {
        tblBranch.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            System.out.println(newValue);
            setData(newValue);
        });
    }

    private void setData(BranchTM row) {
        lblBranchId.setText(row.getId());
        txtLocation.setText(row.getLocation());
        txtEmail.setText(String.valueOf(row.getEmail()));
        txtMobile.setText(String.valueOf(row.getMobile()));
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    }

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        String id = lblBranchId.getText();
        String location = txtLocation.getText();
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        try {
            branchBO.addBranch(new BranchDTO(id, location, email, mobile));
            new Alert(Alert.AlertType.CONFIRMATION,"Branch Added !", ButtonType.OK).show();
            generateNextUserId();
            clearfield();
            loadAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch Not Added !", ButtonType.OK).show();
        }

    }

    @FXML
    void btnClearCustomerOnAction(ActionEvent event) {
        clearfield();
    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {
        String id = lblBranchId.getText();
        try {
            branchBO.deleteBranch(id);
            new Alert(Alert.AlertType.CONFIRMATION,"Branch Added !", ButtonType.OK).show();
            generateNextUserId();
            clearfield();
            loadAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch Not Added !", ButtonType.OK).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        String id = lblBranchId.getText();
        String location = txtLocation.getText();
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        try {
            branchBO.updateBranch(new BranchDTO(id, location, email, mobile ));
            new Alert(Alert.AlertType.CONFIRMATION,"Branch Updated !", ButtonType.OK).show();
            generateNextUserId();
            clearfield();
            loadAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch Not Updated !", ButtonType.OK).show();
        }
    }

}
