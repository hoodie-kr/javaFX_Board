package com.team3.Controller;

import java.io.IOException;

import com.team3.DTO.Board;
import com.team3.Service.BoardService;
import com.team3.Service.BoardServiceImpl;
import com.team3.Util.SceneUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class UpdateController {

    @FXML
    private Button alert;

    @FXML
    private TextField taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    private BoardService boardService = new BoardServiceImpl();
    int no;
    @FXML
    public void delete(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("게시글 삭제");
		alert.setHeaderText("게시글을 정말로 삭제하시겠습니까? (글번호 : " + no + ")");
		alert.setContentText("삭제 처리 후에는 되돌릴 수 없습니다.");
		
		int result = 0;
		if( alert.showAndWait().get() == ButtonType.OK ) {
			result = boardService.delete(no);
		}
		
		if( result > 0 ) {
			System.out.println("글삭제 처리 성공!");
			SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
		}
    }

    @FXML
    public void moveToList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
    }

    @FXML
    public void update(ActionEvent event) throws IOException {
        Board board = new Board(tfTitle.getText(), tfWriter.getText(), taContent.getText() );
		board.setNo(no);
		int result = boardService.update(board);
		if( result > 0 ) {
			System.out.println("글수정 처리 성공!");
			SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
		}
    }

}
