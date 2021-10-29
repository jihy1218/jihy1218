package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Signupcontroller {

    @FXML
    private Label btnback;

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
	void back(MouseEvent event) {
		// 1. 메소드 호출하는 방법 : 1. static / 2. 객체
//		Logincontroller logincontroller = new Logincontroller();
			// 값이 다름

		Logincontroller.getinstance().loadpage("login");
	}
	@FXML
    void signup(ActionEvent event) {

    }
	
}
