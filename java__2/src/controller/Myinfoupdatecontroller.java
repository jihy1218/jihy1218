package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Myinfoupdatecontroller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 0. �α��ε� ���̵��� DB���� ȸ������ ã��
		String loginid = Mainpagecontroller.getinstance().getloginid();
		Member member = MemberDao.getMemberDao().getmember(loginid);
		// 2. DB���� ã�� ȸ������ ���̺��� �ֱ�
		lblid.setText(member.getM_id());
		txtname.setText(member.getM_name());
		txtemail.setText(member.getM_email());
		lblpoint.setText(member.getM_point() + "");
		
	}
    @FXML
    private Button btncancel;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblid;

    @FXML
    private Label lblpoint;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    void cancel(ActionEvent event) {
    	Mainpagecontroller.getinstance().loadpage("myinfo");
    }

    @FXML
    void update(ActionEvent event) {
    	boolean result = MemberDao.getMemberDao().update(lblid.getText(), txtname.getText(), txtemail.getText());
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("ȸ������ �����Ϸ�");
    		alert.showAndWait();
    		Mainpagecontroller.getinstance().loadpage("myinfo");
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("ȸ������ �������� : [�����ڿ��Թ���]");
    		alert.showAndWait();
    	}
    	
    }

}