package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.ProductDao;
import domain.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class Productlistcontroller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		btndelete.setVisible(false);
		btnupdate.setVisible(false);
		
		// 1. DB에서 제품목록 가져오기
		ObservableList<Product> products = ProductDao.getProductDao().productlist();
		// 2. 제품목록을 테이블뷰에 넣어주기
		productlist.setItems(products);
		// 3. dsaldsada
		TableColumn tc = productlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));

		tc = productlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_category"));
		
		tc = productlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_price"));
		
		tc = productlist.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_activation"));
		
		tc = productlist.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_date"));
		
		// 테이블 뷰에서 클릭한아이템을 가져오기
		// 1. 테이블뷰에서 클릭하기
		productlist.setOnMouseClicked(e->{
			// 2. 클릭 이벤트가 마우스 클릭과 같으면
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				product = productlist.getSelectionModel().getSelectedItem();
				// 3. 출력
				Image image = new Image(product.getP_img());
				pimg.setImage(image);
				lblpname.setText(product.getP_name());
				lblpcontents.setText(product.getP_contents());
				lblprice.setText(String.format("%,d" ,product.getP_price()));
				String writer = MemberDao.getMemberDao().midcheck(product.getM_no());
				lblmid.setText(writer);
				if(Mainpagecontroller.getinstance().getloginid().equals(writer)) {
					// 로그인 아이디가 등록한 아이디와 동일하면 
					btndelete.setVisible(true);
					btnupdate.setVisible(true);
				}else {
					btndelete.setVisible(false);
					btnupdate.setVisible(false);
				}
				
			}
		});
		
	}
	
	public static Product product;
	@FXML
	private Button btndelete;

	@FXML
	private Button btnregister;

	@FXML
	private Button btnupdate;

	@FXML
	private Label lblmid;

	@FXML
	private Label lblpcontents;

	@FXML
	private Label lblpname;

	@FXML
	private Label lblprice;

	@FXML
	private ImageView pimg;

	@FXML
	private TableView<Product> productlist;

	@FXML
	void delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("제품을 삭제 하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait();
		if(optional.get()==ButtonType.OK) {
			ProductDao.getProductDao().delete(product.getP_no());
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("삭제 되었습니다."); 
			alert2.showAndWait();
			Mainpagecontroller.getinstance().loadpage("productlist");
		}
	}

	@FXML
	void register(ActionEvent event) {
		Mainpagecontroller.getinstance().loadpage("productregister");
	}

	@FXML
	void update(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("수정후 업데이트버튼을 눌러주세요");
		alert.showAndWait();
		Mainpagecontroller.getinstance().loadpage("productupdate");
	}
}
