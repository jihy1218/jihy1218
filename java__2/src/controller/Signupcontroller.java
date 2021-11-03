package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Signupcontroller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
    @FXML
    private Button btnback;

    @FXML
    private Button btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private PasswordField txtpasswordconfirm;

	
	@FXML
    void signup(ActionEvent event) {

		// 0. 컨트롤 호출 => fx:id 호출 [객체]
		
		// 1. 유효성검사
			// 1. 아이디 길이체크
			if (txtid.getText().length() < 4 || txtid.getText().length() > 13) {
				lblconfirm.setText("아이디는 4~12 글자만 가능합니다."); // 레이블 내용 변경
				return;
			}
			// 2. 비밀번호 길이 체크
			if(txtpassword.getText().length() <4 || txtpassword.getText().length() >9) {
				lblconfirm.setText("비밀번호는 4~8 글자만 가능합니다.");
				return;
			}
			// 3. 비밀번호 동일 체크
			if(!txtpasswordconfirm.getText().equals(txtpassword.getText())) {
				lblconfirm.setText("비밀번호가 동일하지않습니다.");
				return;
			}
			// 4. 이름 길이 체크
			if(txtname.getText().length()<2) {lblconfirm.setText("이름은 2글자이상 가능합니다."); return;}
			// 5. 이메일 길이 체크
			if(txtemail.getText().length()<5 && !txtemail.getText().contains("@")) {lblconfirm.setText("이메일형식으로 입력해주십시오."); return;}
		// 2. 중복체크
			boolean idcheck = MemberDao.getMemberDao().idcheck(txtid.getText());
			if(idcheck) { lblconfirm.setText("현재 사용중인 아이디입니다."); return;}
		
		// 3. 객체화
		Member member = new Member(txtid.getText(), txtpassword.getText(), 
				txtname.getText(), txtemail.getText());
		// 4. 파일 혹은 DB 처리
		boolean result = MemberDao.getMemberDao().signup(member);
		if(result) {
			lblconfirm.setText("가입해주셔서 감사합니다.");
		// 5. 메시지 창을 띄우고 페이지 전환
				Alert alert = new Alert(AlertType.INFORMATION);	// 1. 메시지 객체 생성
				alert.setContentText("회원가입 성공"); 	// 2. 메시지 내용
				alert.setHeaderText("회원가입을축하합니다. [포인트1000지급]");	// 3. 메시지 제목
				alert.setTitle("알림");
				alert.showAndWait();	// 4. 메시지를 띄우고 버튼 입력시까지 대기
				Logincontroller.getinstance().loadpage("login"); // 로그인fxml 파일로 이동
		}else {
			lblconfirm.setText("회원가입실패 : 관리자에게문의 : DB오류");
		}
		
    }
	@FXML
	void back(MouseEvent event) {
		// 1. 메소드 호출하는 방법 : 1. static / 2. 객체
//		Logincontroller logincontroller = new Logincontroller();
			// 값이 다름

		Logincontroller.getinstance().loadpage("login");
	}
	
}
