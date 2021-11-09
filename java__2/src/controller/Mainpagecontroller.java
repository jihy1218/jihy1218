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
		loadpage("home"); // mainpage ����� ����� home.fxml��ġ
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
	
	// ��üȭ
		// ����
	public static Mainpagecontroller instance;
		// ������
	public Mainpagecontroller() {
		instance = this; // [ ���� Ŭ������ ��� ��� ���� ]
	}
		// ��ü ��ȯ
	public static Mainpagecontroller getinstance() {
		return instance;
	}
	
	public String getloginid() {
		return lblloginid.getText();
	}
	// ��� pane  �����ϴ� �޼ҵ�
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

	@FXML	// �α׾ƿ� �޼ҵ� [ ���� �������� �ݱ� --> login�������� ����]
	void logout(ActionEvent event) {
		
		// 0. �޽���â ����
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("�α׾ƿ�");
		alert.setHeaderText("�α׾ƿ� �Ͻðڽ��ϱ�? ");
		alert.setTitle("Ȯ��");
		// �޽��� ��ư�� �������� [ Optional Ŭ���� : null ���� Ŭ����
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // ��ưŸ���� ok�̸�
			// 1. main �������� �����
			btnlogout.getScene().getWindow().hide();
			// 2. login �������� ����
			Stage stage = new Stage();
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false); // �������� ���������
				stage.setTitle("�α���"); // �������� �̸�
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
