package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.MemberDao;
import dao.ProductDao;
import domain.Product;
import domain.ProductDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Homecontroller implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbltotalmember.setText(MemberDao.getMemberDao().membercount()+""); // 내용넣기
//		lbltotalmember.setAlignment(Pos.CENTER);// 정렬
		lbltotalboard.setText(BoardDao.getBoardDao().boardcount()+"");
		lbltotalproduct.setText(ProductDao.getProductDao().productcount()+"");
		
		// 선 차트
//		XYChart.Series series = new XYChart.Series<>(); // 계열 생성
//		series.setName("테스트"); // 2. 계열 이름
//		// 데이터 생성 //3. 데이터생성
//		series.getData().add(new XYChart.Data<>("1",30));
//		series.getData().add(new XYChart.Data<>("2",40));
//		series.getData().add(new XYChart.Data<>("3",60));
//		
		
//		lc.getData().add(series);
//		// 제품등록 날짜 = 가로축 // 제품 수 = 세로축
//		XYChart.Series series = new XYChart.Series<>(); // 1. 계열 생성
//		series.setName("등록 수"); // 2. 계열 이름 
//			// 데이터
//			ObservableList<Product> products = ProductDao.getProductDao().productlist(); 
//			// 날짜로 구분
//			ArrayList<ProductDate> dates = new ArrayList<>();
//			for(Product product : products) { // 모든제품 하나씩 객체 꺼내기
//				String date = product.getP_date().split(" ")[0]; // 날짜만 가져오기
//				for(int i = 0 ; i < dates.size(); i++) {
//					if(dates.get(i).getDate().equals(date)) {
//						dates.get(i).setCount(dates.get(i).getCount()+1);
//						break;
//					}
//				}
//				dates.add(new ProductDate(date, 1)); // 동일한 날짜가 있으면 리스트에 추가
//			}
//			
//			for(ProductDate date : dates) { // 날짜별 개수 리스트에서 하나씩 객체 꺼내기
//				XYChart.Data data = new XYChart.Data<>(date.getDate()+"",date.getCount());
//				series.getData().add(data); // 3. 계열에 값 넣기
//			}
//		lc.getData().add(series); // 4. 계열을 차트에 넣기 
		//
		XYChart.Series series = new XYChart.Series<>(); // 1. 계열생성
		series.setName("제품 수"); // 2. 계열이름
			ArrayList<ProductDate> productDates = ProductDao.getProductDao().productdatelist();
			for(ProductDate productDate : productDates ) {
				// 3. 계열에 값 넣기
					// 1. 값 설정
					XYChart.Data data = new XYChart.Data<>(productDate.getDate(),productDate.getCount());
						// 2. 
							AnchorPane anchorPane = new AnchorPane(); // 1. 컨테이너 만들기
								Label label = new Label(productDate.getCount()+""); // 2. 레이블 생성
								label.setPadding(new Insets(1)); // setPadding ( new Insets(수치)) : 안쪽 여백
							anchorPane.getChildren().add(label); // 3. 컨테이너 레이블 넣기
							
						data.setNode(anchorPane);
					// 2. 계열에 값 넣기
					series.getData().add(data);
			}
		// y축 설정
		lc.getYAxis().setAutoRanging(false); // y축 자동설정 끄기
		
		lc.getData().add(series); // 4. 계열을 차트에 넣기
		
		// 레이블 증감 설정
		if(productDates.get(productDates.size()-1).getCount() > productDates.get(productDates.size()-2).getCount()) {
					// 리스트내 마지막 객체내 날짜의 수 > 리스트내 마지막 전 객체내 날짜의 수
			lbldecrease.setVisible(false); // 감소 레이블 숨기기
		}else {
			lblincrease.setVisible(false); // 증가 레이블 숨기기
		}
		
		// bar 차트 
		XYChart.Series series2 = new XYChart.Series<>();
//		series2.setName("호텔양도");
		// 1.
			HashMap<String , Integer> hashMap = ProductDao.getProductDao().productcategorylist();
			String maxcategorykey = " ";
			int max = 0;
			for(String key : hashMap.keySet()) {
				if(hashMap.get(key)> max) {
					max= hashMap.get(key);
					maxcategorykey = key;
					
				}
					// map에 전체 키를 가져와서 반복문
				XYChart.Data data = new XYChart.Data<>(key,hashMap.get(key));
				series2.getData().add(data);
				
			
			}
		bc.getData().add(series2);
		lblcategory.setText(maxcategorykey);
			
		// pie 차트
		ObservableList<Product> products = ProductDao.getProductDao().productlist();
		
		ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
		for(Product product : products) {
			observableList.add(new PieChart.Data(product.getActivation(), 1));
		}
		
		pc.setData(observableList);
		
		
		
		
		
		
		
		// 1. 모든레코드 검색
		// select * from product
		// 2. p_date 필드 기준으로 분해
		// 		select substring_index(product.p_date ," ", 1) from product
		// 		*substring_index(필드명, "분해기준" , 가져올번호)
		//		*2021-11-08 13:40:35 	-> 	2021-11-08  	:1
		//									13:40:35		:2
		// 3. 그룹 [group by 필드명]
		// GROUP BY select substring_index(product.p_date," ",1) from product
		// 4. 그룹조건 : [having: 그룹내 조건 <-----> where그룹의 조건]
		// 		select 
		//		
	}
	@FXML
	private Label lbltotalmember;
	
	@FXML
	private Label lbltotalboard;
	
	@FXML
	private Label lbltotalproduct;
	
	@FXML
	private Label lblcategory;
	
	@FXML
	private PieChart pc;
	
	@FXML
	private LineChart lc;
	
	@FXML
	private BarChart bc;
	
	@FXML
	private Label lblincrease;
	
	@FXML
	private Label lbldecrease;
}
