package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class Myinfocontroller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 0. 로그인된 아이디의 DB에서 회원정보 찾기
		String loginid = Mainpagecontroller.getinstance().getloginid();
		Member member = MemberDao.getMemberDao().getmember(loginid);
		// 2. DB에서 찾은 회원정보 레이블에 넣기
		lblid.setText(member.getM_id());
		lblname.setText(member.getM_name());
		lblemail.setText(member.getM_email());
		lblpoint.setText(member.getM_point()+"");
	}


    @FXML
    private Label lblpoint;
    
	@FXML
	private Button btndelete;

	@FXML
	private Button btnupdate;

	@FXML
	private Label lblemail;

	@FXML
	private Label lblid;

	@FXML
	private Label lblname;

	@FXML
	void delete(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림");
		alert.setHeaderText("정말 회원탈퇴 하시겠습니까?");
		
		Optional<ButtonType> optional = alert.showAndWait();
		if(optional.get() == ButtonType.OK) {
			// 회원탈퇴 진행
			boolean result = MemberDao.getMemberDao().delete(lblid.getText());
		
			Alert alert2 = new Alert(AlertType.INFORMATION);
			
			if(result) {
				alert2.setHeaderText("회원탈퇴 되었습니다.");
				alert2.setTitle("알림");
				alert2.showAndWait();
				
				// 1. main스테이지 숨기기
				btndelete.getScene().getWindow().hide();
				
				// 2. login 스테이지 열기
				Stage stage = new Stage();
				try {
					Parent parent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false); // 스테이지 사이즈고정
					stage.setTitle("로그인"); // 스테이지 이름
					Image image = new Image("file:D:/JavaWeb/jihy1218/java__2/src/fxml/icon2.png");
					stage.getIcons().add(image);
					stage.show();
				} catch (Exception e) {
					
				}
				
				
			}else {
				alert2.setHeaderText("DB 오류 [ 관리자에게 문의 ]");
				alert2.setTitle("알림");
				alert2.showAndWait();
			}
		}
	}

	@FXML
	void update(ActionEvent event) {
		Mainpagecontroller.getinstance().loadpage("myinfoupdate");
	}

}
