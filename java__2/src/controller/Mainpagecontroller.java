package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Mainpagecontroller implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Logincontroller.getinstance().getid());
		loadpage("home"); // mainpage 실행시 가운데를 home.fxml배치
	}

	@FXML
	private Button btnchattng;

	@FXML
	private Button btncommunity;

	@FXML
	private Button btnhome;

	@FXML
	private Button btnlogout;

	@FXML
	private Button btnmyinfo;

	@FXML
	private Button btnproduct;

	@FXML
	private Label lblloginid;

	@FXML
	private AnchorPane lp;

	@FXML
	private BorderPane mainpageborderpane;
	
	// 객체화
		// 선언
	public static Mainpagecontroller instance;
		// 생성자
	public Mainpagecontroller() {
		instance = this; // [ 현재 클래스의 모든 멤버 포함 ]
	}
		// 객체 반환
	public static Mainpagecontroller getinstance() {
		return instance;
	}
	
	public String getloginid() {
		return lblloginid.getText();
	}
	// 가운데 pane  변경하는 메소드
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainpageborderpane.setCenter(parent);
		} catch (Exception e) {}
	}
	

	@FXML
	void chatting(ActionEvent event) {
		loadpage("chatting");
	}

	@FXML
	void community(ActionEvent event) {
		loadpage("boardlist");
	}

	@FXML
	void home(ActionEvent event) {
		loadpage("home");

	}

	@FXML	// 로그아웃 메소드 [ 현재 스테이지 닫기 --> login스테이지 열기]
	void logout(ActionEvent event) {
		
		// 0. 메시지창 띄우기
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("로그아웃");
		alert.setHeaderText("로그아웃 하시겠습니까? ");
		alert.setTitle("확인");
		// 메시지 버튼을 눌렀을떄 [ Optional 클래스 : null 포함 클래스
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // 버튼타입이 ok이면
			// 1. main 스테이지 숨기기
			btnlogout.getScene().getWindow().hide();
			// 2. login 스테이지 띄우기
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
		}
	}

	@FXML
	void myinfo(ActionEvent event) {
		loadpage("myinfo");
		
	}

	@FXML
	void product(ActionEvent event) {
		loadpage("productlist");
	}
}
