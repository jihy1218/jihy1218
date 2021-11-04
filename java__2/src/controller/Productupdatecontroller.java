package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import dao.ProductDao;
import domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Productupdatecontroller implements Initializable{

	Product product = Productlistcontroller.product;	// 1.테이블뷰에서 클릭된 객체
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
		txtpname.setText(product.getP_name());				// 2. 클릭된 객체 제품명
		txtpcontents.setText(product.getP_contents());		// 3. 클릭된 객체 제품내용
		txtprice.setText(product.getP_price()+"");			// 4. 클릭된 객체 제품가격
			Image image = new Image(product.getP_img());	// 5. 클릭된 객체 이미지
		pimg.setImage(image);
		lblimgpath.setText(product.getP_img());
		pimage = product.getP_img();
		// 제품에 저장된 카테고리별 라디오버튼 클릭 세팅 [setSelected(true)]
		if(product.getP_category().equals("호텔양도")) {opt_1.setSelected(true);}
		if(product.getP_category().equals("렌트카양도")) {opt_2.setSelected(true);}
		if(product.getP_category().equals("항공권양도")) {opt_3.setSelected(true);}
		if(product.getP_category().equals("ACC")) {opt_4.setSelected(true);}
		
	}

    @FXML
    private Button btncancel;

    @FXML
    private Button btnimgadd;

    @FXML
    private Button btnupdate;

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

    private Stage stage;
    private String pimage;
    @FXML
    void imgadd(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("그림파일 : Image File", "*png" , "*jpg", "*gif"));
    	// 선택된 파일의 경로를 파일클래스에 저장
    	File file = fileChooser.showOpenDialog(stage);
    	lblimgpath.setText("파일경로 : "+ file.getPath());
    	pimage = file.toURI().toString();
    	Image image = new Image(pimage);
    	pimg.setImage(image);
    }

    @FXML
    void update(ActionEvent event) {
    	String p_name = txtpname.getText();
    	String p_contents = txtpcontents.getText();
    	int price = Integer.parseInt(txtprice.getText());
    	String category = "";
    	if(opt_1.isSelected()) {category="호텔양도";}
		if(opt_2.isSelected()) {category="렌트카양도";}
		if(opt_3.isSelected()) {category="항공권양도";}
		if(opt_4.isSelected()) {category="ACC";}
		
		// 객체화 
		Product product2 = new Product(
				product.getP_no(), 
				p_name, 
				pimage, 
				p_contents, 
				category, 
				price, 
				0, 
				"0", 
				0);
		// DB 넣기
		boolean result = ProductDao.getProductDao().update(product2);
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("제품 수정 완료");
			alert.showAndWait();
			Mainpagecontroller.getinstance().loadpage("productlist");
		}
    	
    	
    	
    }

}
