package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Findpasswordcontroller implements Initializable{

	private static Findpasswordcontroller intance;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}

	@FXML
	private Label btnback;

	@FXML
	private Button btnfindpassword;

	@FXML
	private Label lblconfirm;

	@FXML
	private AnchorPane loginpane;

	@FXML
	private TextField txtemail;

	@FXML
	private TextField txtid;

	@FXML
	void back(MouseEvent event) {
    	Logincontroller.getinstance().loadpage("login");

	}

	@FXML
	void findpassword(MouseEvent event) {
		String result = MemberDao.getMemberDao().findpassword(txtid.getText(), txtemail.getText());
		if(result != null) {
			// 메일전송
		}else {
			lblconfirm.setText("동일한 회원정보가 없습니다.");
		}
	}
}
