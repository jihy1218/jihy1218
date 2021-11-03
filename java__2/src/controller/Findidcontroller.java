package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Findidcontroller implements Initializable{

	private static Findidcontroller instance;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Button btnback;

    @FXML
    private Button btnfindid;

    @FXML
    private AnchorPane findidpane;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    void back(MouseEvent event) {
    	Logincontroller.getinstance().loadpage("login");
    }

    @FXML
    void findid(MouseEvent event) {
    	if(txtid.getText().length()<2) { lblconfirm.setText("이름은 2글자이상가능합니다."); return;}
    	if(txtemail.getText().length()<5 && !txtemail.getText().contains("@")) {lblconfirm.setText("이메일형식으로 입력해주십시오."); return;}
    	String result = MemberDao.getMemberDao().findid(txtid.getText(), txtemail.getText());
    	if(result!= null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("아이디찾기성공!!");
    		alert.setHeaderText("회원님의 아이디는 : " + result);
    		alert.setTitle("알림");
    		alert.showAndWait();
    		Logincontroller.getinstance().loadpage("login");
    	}else {
    		lblconfirm.setText("아이디찾기 실패: 관리자에게 문의");
    	}
    	
    }
}
