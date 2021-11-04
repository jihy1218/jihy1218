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
		// 유효성 검사 생략 
		String pname = txtpname.getText();		
		String pcontents = txtpcontents.getText();
		int price = Integer.parseInt(txtprice.getText());
		String pcategory = "";
			if(opt_1.isSelected()) {pcategory="호텔양도";}
			if(opt_2.isSelected()) {pcategory="렌트카양도";}
			if(opt_3.isSelected()) {pcategory="항공권양도";}
			if(opt_4.isSelected()) {pcategory="ACC";}
			// 로그인된 id의 회원번호 검색 DB처리
			int m_no = MemberDao.getMemberDao().mnocheck(Mainpagecontroller.getinstance().getloginid());
		// 객체화
		Product product =new Product(pname, pimage, pcontents, pcategory, price, 1, m_no);
		// DB처리
		boolean result = ProductDao.getProductDao().register(product);
		Alert alert = new Alert(AlertType.INFORMATION);
		if(result) {
			alert.setHeaderText("제품등록 성공 "); alert.showAndWait(); // 메시지창 띄우기
			Mainpagecontroller.getinstance().loadpage("productlist"); // 페이지 전환
		}
		
	}
	// 파일 경로 추가
	private String pimage;	// 파일 경로 저장할 변수
	private Stage stage;	// 파일경로 찾을 화면
	
	@FXML
	void imgadd(ActionEvent event) {
		// 1. 파일 선택 클래스
		FileChooser fileChooser = new FileChooser();	// 파일 선택시 경로 저장
		// 2. 파일 스테이지 설정 getExtensionFilters : 선택할 파일 필터
		fileChooser.getExtensionFilters().add(
				new ExtensionFilter("그림파일 : Image File", "*png" , "*jpg" ,"*gif"));
		// 3. 스테이지 실행
		File file = fileChooser.showOpenDialog(stage);
			// * 선택한 파일을 파일클래스에 저장
		lblimgpath.setText("파일경로 : " + file.getPath());
			// 
		pimage = file.toURI().toString(); // 파일의 실제[real] 경로
			//		System.out.println("URL경로 : " + file.getPath());
			//		System.out.println("URI경로 : " + pimage);
		
		Image image = new Image(pimage);
		pimg.setImage(image);
	}

}
