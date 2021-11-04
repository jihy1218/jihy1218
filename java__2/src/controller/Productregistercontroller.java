package controller;

import java.io.File;

import dao.MemberDao;
import dao.ProductDao;
import domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Productregistercontroller {

	@FXML
	private Button btncancel;

	@FXML
	private Button btnimgadd;

	@FXML
	private Button btnregister;

	@FXML
	private ToggleGroup category;

	@FXML
	private Label lblimgpath;

	@FXML
	private RadioButton opt_1;

	@FXML
	private RadioButton opt_2;

	@FXML
	private RadioButton opt_3;

	@FXML
	private RadioButton opt_4;

	@FXML
	private ImageView pimg;

	@FXML
	private TextArea txtpcontents;

	@FXML
	private TextField txtpname;

	@FXML
	private TextField txtprice;

	@FXML
	void cancel(ActionEvent event) {
		Mainpagecontroller.getinstance().loadpage("productlist");
	}

	@FXML
	void register(ActionEvent event) {
		// ��ȿ�� �˻� ���� 
		String pname = txtpname.getText();		
		String pcontents = txtpcontents.getText();
		int price = Integer.parseInt(txtprice.getText());
		String pcategory = "";
			if(opt_1.isSelected()) {pcategory="ȣ�ھ絵";}
			if(opt_2.isSelected()) {pcategory="��Ʈī�絵";}
			if(opt_3.isSelected()) {pcategory="�װ��Ǿ絵";}
			if(opt_4.isSelected()) {pcategory="ACC";}
			// �α��ε� id�� ȸ����ȣ �˻� DBó��
			int m_no = MemberDao.getMemberDao().mnocheck(Mainpagecontroller.getinstance().getloginid());
		// ��üȭ
		Product product =new Product(pname, pimage, pcontents, pcategory, price, 1, m_no);
		// DBó��
		boolean result = ProductDao.getProductDao().register(product);
		Alert alert = new Alert(AlertType.INFORMATION);
		if(result) {
			alert.setHeaderText("��ǰ��� ���� "); alert.showAndWait(); // �޽���â ����
			Mainpagecontroller.getinstance().loadpage("productlist"); // ������ ��ȯ
		}
		
	}
	// ���� ��� �߰�
	private String pimage;	// ���� ��� ������ ����
	private Stage stage;	// ���ϰ�� ã�� ȭ��
	
	@FXML
	void imgadd(ActionEvent event) {
		// 1. ���� ���� Ŭ����
		FileChooser fileChooser = new FileChooser();	// ���� ���ý� ��� ����
		// 2. ���� �������� ���� getExtensionFilters : ������ ���� ����
		fileChooser.getExtensionFilters().add(
				new ExtensionFilter("�׸����� : Image File", "*png" , "*jpg" ,"*gif"));
		// 3. �������� ����
		File file = fileChooser.showOpenDialog(stage);
			// * ������ ������ ����Ŭ������ ����
		lblimgpath.setText("���ϰ�� : " + file.getPath());
			// 
		pimage = file.toURI().toString(); // ������ ����[real] ���
			//		System.out.println("URL��� : " + file.getPath());
			//		System.out.println("URI��� : " + pimage);
		
		Image image = new Image(pimage);
		pimg.setImage(image);
	}

}
