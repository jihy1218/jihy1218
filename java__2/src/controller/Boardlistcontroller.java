package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import domain.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Boardlistcontroller implements Initializable {


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 1. DAO 호출
		ObservableList<Board> boards = BoardDao.getBoardDao().boardlist();
		//
		TableColumn tc = boardlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_no"));
		
		tc = boardlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
		
		tc = boardlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_write"));
		
		tc = boardlist.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
		
		tc = boardlist.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_view"));
		
		
		// 3. 테이블뷰에 리스트 설정
		boardlist.setItems(boards);
		
		
		// 4. 클릭한 아이템을 가지고 페이지 전환
//		boardlist.setOnMouseClicked(e -> {정의 return});
			// 인수 -> 정의 : 익명메소드(1회성 메소드)
		boardlist.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {	// 해당 이벤트가 클릭이면
				board = boardlist.getSelectionModel().getSelectedItem();
								// 테이블뷰에 선택된 모델의 아이템 [객체]
				// 페이지 전환
				Mainpagecontroller.getinstance().loadpage("boardview");
			}
		});
			
		}
	public static Board board;	

    @FXML
    private TableView<Board> boardlist;
    			// 테이블에 넣을 객체의 클래스명 : 제네릭
    @FXML
    private Button btnwrite;

    @FXML
    void write(ActionEvent event) {
    	Mainpagecontroller.getinstance().loadpage("boardwrite");
    }

}
