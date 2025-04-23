package com.team3.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.team3.DTO.Board;
import com.team3.Service.BoardService;
import com.team3.Service.BoardServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;rtyValueFactory;
import javafx.scene.input.MouseEvent;

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

    BoardService boardService = new BoardServiceImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 데이터 초기화
		List<Board> boardList = new ArrayList<>();
		boardList = boardService.list();
		
		for (Board board : boardList) {
			System.out.println(board);
		}
		
		ObservableList<Board> list = FXCollections.observableArrayList(boardList);
		
		colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colCreatedAt.setCellValueFactory(new PropertyValueFactory<>("CreatedAt"));
		colUpdatedAt.setCellValueFactory(new PropertyValueFactory<>("UpdatedAt"));
		colCbDelete.setCellValueFactory(new PropertyValueFactory<>("CbDelete"));
		
		// TableView에 데이터 리스트 지정
		boardTableView.setItems(list);
		
		cbAll.setSelected(false);
		// 전체 체크박스 클릭 이벤트
		cbAll.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				CheckBox checkBox = (CheckBox) event.getSource();
				boolean checkAll = checkBox.isSelected();
				boardTableView.getItems().stream().forEach((board) -> {
					board.getCbDelete().setSelected(checkAll);
				});
			}
			
		});
		
		/**
		 * 테이블뷰 더블 클릭 이벤트
		 * : 글이 존재하는 행을 더블클릭하면 해당 글 읽기 화면으로 이동
		 */
		boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				if (event.getClickCount() == 2 && boardTableView.getSelectionModel().getSelectedItem() != null) {
					int no = boardTableView.getSelectionModel().getSelectedItem().getNo();
					try {
						ReadController readController = (ReadController) SceneUtil.getInstance().getController(UI.READ.getPath());
						readController.read(no);
						
						Parent root = SceneUtil.getInstance().getRoot();
						SceneUtil.getInstance().switchScene(event, UI.READ.getPath(), root);
					} catch (IOException e) {
						System.err.println("[목록->읽기] 화면 이동 중 예외 발생");
						e.printStackTrace();
					}
				}
			}
			
		});
		
	}

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
