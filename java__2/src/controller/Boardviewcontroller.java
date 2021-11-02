package controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardviewcontroller implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Board board = Boardlistcontroller.board;
		txttitle.setText(board.getB_title());
		txtcontents.setText(board.getB_contents());
		if(!Mainpagecontroller.getinstance().getloginid().equals(board.getB_write())) {
			// 게시물 작성자와 로그인된 작성자가 다를경우
			btnupdate.setVisible(false);
			btndelete.setVisible(false);
			
		}
		
		
		
		
	}
    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnreplywrite;

    @FXML
    private Button btnupdate;

    @FXML
    private TableView<?> replylist;

    @FXML
    private TextArea txtcontents;

    @FXML
    private TextField txttitle;

    @FXML
    void back(ActionEvent event) {
    	Mainpagecontroller.getinstance().loadpage("boardlist");
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void replywrite(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

}
