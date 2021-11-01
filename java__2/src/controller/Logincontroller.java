package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
	
	public String getid() {
		return txtid.getText();
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
    private Button btnsignup;

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
    	
    	loadpage("findid");
    }

    @FXML
	void findpassword(MouseEvent event) {

    	loadpage("findpassword");
    	
	}

	@FXML
	void login(MouseEvent event) {

		// 1. Dao��ü �޼ҵ� ȣ�� [ 
		boolean result = MemberDao.getMemberDao().login(txtid.getText(), txtpassword.getText());
		
		if(result) {
			lblconfirm.setText("�α��μ���");
			// ������������ ����
			btnlogin.getScene().getWindow().hide();		// ȭ������			
			// ���������� ��������
			Stage stage = new Stage();
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/fxml/mainpage.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false); // �������� ���������
				stage.setTitle("�α���"); // �������� �̸�
				Image image = new Image("file:D:/JavaWeb/jihy1218/java__2/src/fxml/icon2.png");
				stage.getIcons().add(image);
				stage.show();
			} catch (Exception e) {
				
			}
			
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
