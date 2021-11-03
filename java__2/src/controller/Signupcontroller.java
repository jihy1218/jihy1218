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

		// 0. ��Ʈ�� ȣ�� => fx:id ȣ�� [��ü]
		
		// 1. ��ȿ���˻�
			// 1. ���̵� ����üũ
			if (txtid.getText().length() < 4 || txtid.getText().length() > 13) {
				lblconfirm.setText("���̵�� 4~12 ���ڸ� �����մϴ�."); // ���̺� ���� ����
				return;
			}
			// 2. ��й�ȣ ���� üũ
			if(txtpassword.getText().length() <4 || txtpassword.getText().length() >9) {
				lblconfirm.setText("��й�ȣ�� 4~8 ���ڸ� �����մϴ�.");
				return;
			}
			// 3. ��й�ȣ ���� üũ
			if(!txtpasswordconfirm.getText().equals(txtpassword.getText())) {
				lblconfirm.setText("��й�ȣ�� ���������ʽ��ϴ�.");
				return;
			}
			// 4. �̸� ���� üũ
			if(txtname.getText().length()<2) {lblconfirm.setText("�̸��� 2�����̻� �����մϴ�."); return;}
			// 5. �̸��� ���� üũ
			if(txtemail.getText().length()<5 && !txtemail.getText().contains("@")) {lblconfirm.setText("�̸����������� �Է����ֽʽÿ�."); return;}
		// 2. �ߺ�üũ
			boolean idcheck = MemberDao.getMemberDao().idcheck(txtid.getText());
			if(idcheck) { lblconfirm.setText("���� ������� ���̵��Դϴ�."); return;}
		
		// 3. ��üȭ
		Member member = new Member(txtid.getText(), txtpassword.getText(), 
				txtname.getText(), txtemail.getText());
		// 4. ���� Ȥ�� DB ó��
		boolean result = MemberDao.getMemberDao().signup(member);
		if(result) {
			lblconfirm.setText("�������ּż� �����մϴ�.");
		// 5. �޽��� â�� ���� ������ ��ȯ
				Alert alert = new Alert(AlertType.INFORMATION);	// 1. �޽��� ��ü ����
				alert.setContentText("ȸ������ ����"); 	// 2. �޽��� ����
				alert.setHeaderText("ȸ�������������մϴ�. [����Ʈ1000����]");	// 3. �޽��� ����
				alert.setTitle("�˸�");
				alert.showAndWait();	// 4. �޽����� ���� ��ư �Է½ñ��� ���
				Logincontroller.getinstance().loadpage("login"); // �α���fxml ���Ϸ� �̵�
		}else {
			lblconfirm.setText("ȸ�����Խ��� : �����ڿ��Թ��� : DB����");
		}
		
    }
	@FXML
	void back(MouseEvent event) {
		// 1. �޼ҵ� ȣ���ϴ� ��� : 1. static / 2. ��ü
//		Logincontroller logincontroller = new Logincontroller();
			// ���� �ٸ�

		Logincontroller.getinstance().loadpage("login");
	}
	
}
