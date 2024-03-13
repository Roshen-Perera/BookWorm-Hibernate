package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BookBO;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dto.BookDTO;
import lk.ijse.dto.BranchDTO;
import lk.ijse.dto.tm.BookTM;
import lk.ijse.dto.tm.BranchTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookFormController {

    @FXML
    private JFXComboBox<?> cmdBranchId;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colYear;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBranchId;

    @FXML
    private Label lblBranchName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<BookTM> tblBranch;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookGenre;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBookQty;

    @FXML
    private TextField txtSearch;
    BranchBO branchBO = (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BRANCH);

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    public void initialize(){

    }
    private void clearFields(){
        lblBranchId.setText("");
        txtBookName.setText("");
        txtBookAuthor.setText("");
        txtBookGenre.setText("");
        txtBookQty.setText("");
        lblBranchId.setText("");
        lblBranchName.setText("");
    }


    private void generateNextBookId() throws SQLException, IOException, ClassNotFoundException {
        String nextId = bookBO.generateNewUserID();
        lblBookId.setText(nextId);
    }

    private void loadAllBranches() throws Exception {
        ObservableList<BookTM> obList = FXCollections.observableArrayList();
        try{
            List<BookDTO> dtoList = bookBO.getAllBookes();

            for (BookDTO dto : dtoList) {
                obList.add(
                        new BookTM(
                                dto.getId(),
                                dto.getName(),
                                dto.getAuthor(),
                                dto.getGenre(),
                                dto.getQty(),
                                dto.getBranchId()
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

    private void setData(BookTM row) {
        lblBranchId.setText(row.getId());
        txtBookName.setText(row.getName());
        txtBookAuthor.setText(String.valueOf(row.getAuthor()));
        txtBookGenre.setText(String.valueOf(row.getGenre()));
        txtBookQty.setText(String.valueOf(row.getQty()));
        lblBranchId.setText(String.valueOf(row.getBranchId()));
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        String id = lblBookId.getText();
        String name = txtBookName.getText();
        String author = txtBookAuthor.getText();
        String genre = txtBookGenre.getText();
        int qty = Integer.parseInt(txtBookQty.getText());
        String branchId = lblBranchId.getText();
        try {
            bookBO.addBook(new BookDTO(id, name, author, genre, qty, branchId));
            new Alert(Alert.AlertType.CONFIRMATION,"Book Added !", ButtonType.OK).show();
            generateNextBookId();
            clearFields();
            loadAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Book Not Added !", ButtonType.OK).show();
        }
    }

    @FXML
    void btnClearCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {
        String id = lblBookId.getText();
        try {
            bookBO.deleteBook(id);
            new Alert(Alert.AlertType.CONFIRMATION,"Book Deleted !", ButtonType.OK).show();
            generateNextBookId();
            clearFields();
            loadAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Book Not Deleted !", ButtonType.OK).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id = txtSearch.getText();
        BookDTO bookDto = /*BookBO.searchItem(id);*/null;
        if (bookDto != null) {
            txtSearch.setText(bookDto.getId());
            txtBookName.setText(bookDto.getName());
            txtBookAuthor.setText(bookDto.getAuthor());
            txtBookGenre.setText(String.valueOf(bookDto.getGenre()));
            txtBookQty.setText(String.valueOf(bookDto.getQty()));
            lblBranchId.setText(bookDto.getBranchId());
        }else {
            new Alert(Alert.AlertType.INFORMATION, "Customer Saved").show();
        }
    }

    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {
        String id = lblBookId.getText();
        String name = txtBookName.getText();
        String author = txtBookAuthor.getText();
        String genre = txtBookGenre.getText();
        int qty = Integer.parseInt(txtBookQty.getText());
        String branchId = lblBranchId.getText();
        try {
            bookBO.updateBook(new BookDTO(id, name, author, genre, qty, branchId));
            new Alert(Alert.AlertType.CONFIRMATION,"Book Updated !", ButtonType.OK).show();
            generateNextBookId();
            clearFields();
            loadAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Book Not Update !", ButtonType.OK).show();
        }
    }

    @FXML
    void cmbBranchOnAction(ActionEvent event) {
        String id = String.valueOf(cmdBranchId.getValue());
//        CustomerModel customerModel = new CustomerModel();
        BranchDTO branchDto = null;/*branchBO.searchSupplier(id);*/
        lblBranchId.setText(branchDto.getId());
        lblBranchName.setText(branchDto.getLocation());

    }

}
