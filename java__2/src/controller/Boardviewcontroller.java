package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.BoardDao;
import domain.Board;
import domain.Reply;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardviewcontroller implements Initializable {

	Board board = Boardlistcontroller.board;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			// DB 조회수증가
			BoardDao.getBoardDao().viewupdate(board.getB_no());
		
		txttitle.setText(board.getB_title());
		txtcontents.setText(board.getB_contents());
		lblwrite.setText("작성자 : "+board.getB_write());
		lbldate.setText("Date : "+ board.getB_date().split(" ")[0]);
		lblview.setText("조회수 : "+ (board.getB_view()+1));
		if(!Mainpagecontroller.getinstance().getloginid().equals(board.getB_write())) {
			// 게시물 작성자와 로그인된 작성자가 다를경우
			btnupdate.setVisible(false);
			btndelete.setVisible(false);
		}
	}
    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private Label lblwrite;
    
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
    private TextArea txtreply;
    
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
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("정말 게시물을 삭제하시겠습니까?");
    	alert.setTitle("알림");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = BoardDao.getBoardDao().delete(board.getB_no());
    		if(result) {Mainpagecontroller.getinstance().loadpage("boardlist");}
    	}
    }

    @FXML
    void replywrite(ActionEvent event) {
    	Reply reply = new Reply(txtreply.getText(), Mainpagecontroller.getinstance().getloginid(), board.getB_no());
    	boolean result = BoardDao.getBoardDao().replywrite(reply);
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("댓글등록완료");
    		alert.showAndWait();
    	}
    }
    
    boolean upcheck = true;
    @FXML
    void update(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    	if(upcheck) {
		    	alert.setHeaderText("내용 수정후 다시 버튼 클릭시 수정 완료 됩니다.");
		    	alert.setTitle("알림");
		    	alert.showAndWait();
		    	txttitle.setEditable(true);
		    	txtcontents.setEditable(true);
		    	upcheck = false;
	    	}else {
	    		BoardDao.getBoardDao().update(board.getB_no(),txttitle.getText(),txtcontents.getText());
	    		alert.setTitle("알림");
	    		alert.setHeaderText("게시물이 수정되었습니다.");
	    		alert.showAndWait();
	    		
	    		upcheck=true;
	    		txtcontents.setEditable(false);
	    		txttitle.setEditable(false);
	    		Mainpagecontroller.getinstance().loadpage("boardlist");
	    	}
    }

}
