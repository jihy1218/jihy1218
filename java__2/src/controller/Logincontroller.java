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
										// �ʱ�ȭ ���õ� �޼ҵ� ����
	// ���� Ŭ������ ��üȭ [Ŭ���� ��
		// 1. static ���� ����
	private static Logincontroller instance;
	
	public Logincontroller() {
		// 2. ���� Ŭ������ �޸� ȣ�� -> this
		instance = this;
	}
	
	public static Logincontroller getinstance() {
		return instance;
	}
	// fxml ����� �ʱⰪ ���� �޼ҵ�
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

		// txt �Էµ� ���̵�� �н����� ȸ���� �����ϸ� �α��� ����
		if(txtid.getText().equals("admin") && txtpassword.getText().equals("1234")) {
			// ���̵�� �н����尡 �����ϸ� �α��� ����
			lblconfirm.setText("�α��μ���");
		}else {
			lblconfirm.setText("�α��ν���:������ ȸ�������� �����ϴ�.");
		}
	}

	@FXML
	void signup(MouseEvent event) {
		
		loadpage("signup");
	}

	// boarderpane center ���� 
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainborderpane.setCenter(parent);
		} catch (Exception e) {
			
		}
	}
	

}
