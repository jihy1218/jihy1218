package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Logincontroller implements Initializable{
										// 초기화 관련된 메소드 제공
	// 현재 클래스를 객체화 [클래스 객
		// 1. static 변수 선언
	private static Logincontroller instance;
	
	public Logincontroller() {
		// 2. 현재 클래스의 메모리 호출 -> this
		instance = this;
	}
	
	public static Logincontroller getinstance() {
		return instance;
	}
	// fxml 실행시 초기값 설정 메소드
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			lblconfirm.setText("");
	}
	
	
    @FXML
    private Label btnfind;

    @FXML
    private Button btnlogin;

    @FXML
    private Label btnpasswordfind;

    @FXML
    private Label btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane loginpane;

    @FXML
    private BorderPane mainborderpane;

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    void findid(MouseEvent event) {

    }

    @FXML
	void findpassword(MouseEvent event) {

	}

	@FXML
	void login(MouseEvent event) {

		// txt 입력된 아이디와 패스워드 회원과 동일하면 로그인 성공
		if(txtid.getText().equals("admin") && txtpassword.getText().equals("1234")) {
			// 아이디와 패스워드가 동일하면 로그인 성공
			lblconfirm.setText("로그인성공");
		}else {
			lblconfirm.setText("로그인실패:동일한 회원정보가 없습니다.");
		}
	}

	@FXML
	void signup(MouseEvent event) {
		
		loadpage("signup");
	}

	// boarderpane center 변경 
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainborderpane.setCenter(parent);
		} catch (Exception e) {
			
		}
	}
	

}
