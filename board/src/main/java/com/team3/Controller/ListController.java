package com.team3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListController {

    @FXML
    private TableView<Board> boardTableView;
    
    @FXML
    private TableColumn<Board, Integer> colNo;

    @FXML
    private TableColumn<Board, String> colTitle;

    @FXML
    private TableColumn<Board, String> colWriter;

    @FXML
    private TableColumn<Board, String> colCreatedAt;

    @FXML
    private TableColumn<Board, String> colUpdatedAt;

    @FXML
    private TableColumn<Board, CheckBox> colCbDelete;

    @FXML
    private CheckBox cbAll;

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void deleteSelected(ActionEvent event) {

    }

    @FXML
    void moveToInsert(ActionEvent event) {

    }

}
