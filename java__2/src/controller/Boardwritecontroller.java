package controller;

import dao.BoardDao;
import domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardwritecontroller {


    @FXML
    private Button btncancel;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontents;

    @FXML
    private TextField txttitle;

    @FXML
    void cancel(ActionEvent event) {
    	Mainpagecontroller.getinstance().loadpage("boardlist");
    }

    @FXML
    void write(ActionEvent event) {
    	
    	Board board = new Board(txttitle.getText(), txtcontents.getText(), Mainpagecontroller.getinstance().getloginid());
    	boolean result = BoardDao.getBoardDao().write(board);
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(result) {
    		alert.setHeaderText("게시물 등록 성공");
    		alert.showAndWait();
    		Mainpagecontroller.getinstance().loadpage("boardlist");
    	}else {
    		alert.setHeaderText("게시물 등록실패 [관리자에게 문의]");
    		alert.showAndWait();
    	}
    }
}
