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
		lbltotalmember.setText(MemberDao.getMemberDao().membercount()+""); // ����ֱ�
//		lbltotalmember.setAlignment(Pos.CENTER);// ����
		lbltotalboard.setText(BoardDao.getBoardDao().boardcount()+"");
		lbltotalproduct.setText(ProductDao.getProductDao().productcount()+"");
		
		// �� ��Ʈ
//		XYChart.Series series = new XYChart.Series<>(); // �迭 ����
//		series.setName("�׽�Ʈ"); // 2. �迭 �̸�
//		// ������ ���� //3. �����ͻ���
//		series.getData().add(new XYChart.Data<>("1",30));
//		series.getData().add(new XYChart.Data<>("2",40));
//		series.getData().add(new XYChart.Data<>("3",60));
//		
		
//		lc.getData().add(series);
//		// ��ǰ��� ��¥ = ������ // ��ǰ �� = ������
//		XYChart.Series series = new XYChart.Series<>(); // 1. �迭 ����
//		series.setName("��� ��"); // 2. �迭 �̸� 
//			// ������
//			ObservableList<Product> products = ProductDao.getProductDao().productlist(); 
//			// ��¥�� ����
//			ArrayList<ProductDate> dates = new ArrayList<>();
//			for(Product product : products) { // �����ǰ �ϳ��� ��ü ������
//				String date = product.getP_date().split(" ")[0]; // ��¥�� ��������
//				for(int i = 0 ; i < dates.size(); i++) {
//					if(dates.get(i).getDate().equals(date)) {
//						dates.get(i).setCount(dates.get(i).getCount()+1);
//						break;
//					}
//				}
//				dates.add(new ProductDate(date, 1)); // ������ ��¥�� ������ ����Ʈ�� �߰�
//			}
//			
//			for(ProductDate date : dates) { // ��¥�� ���� ����Ʈ���� �ϳ��� ��ü ������
//				XYChart.Data data = new XYChart.Data<>(date.getDate()+"",date.getCount());
//				series.getData().add(data); // 3. �迭�� �� �ֱ�
//			}
//		lc.getData().add(series); // 4. �迭�� ��Ʈ�� �ֱ� 
		//
		XYChart.Series series = new XYChart.Series<>(); // 1. �迭����
		series.setName("��ǰ ��"); // 2. �迭�̸�
			ArrayList<ProductDate> productDates = ProductDao.getProductDao().productdatelist();
			for(ProductDate productDate : productDates ) {
				// 3. �迭�� �� �ֱ�
					// 1. �� ����
					XYChart.Data data = new XYChart.Data<>(productDate.getDate(),productDate.getCount());
						// 2. 
							AnchorPane anchorPane = new AnchorPane(); // 1. �����̳� �����
								Label label = new Label(productDate.getCount()+""); // 2. ���̺� ����
								label.setPadding(new Insets(1)); // setPadding ( new Insets(��ġ)) : ���� ����
							anchorPane.getChildren().add(label); // 3. �����̳� ���̺� �ֱ�
							
						data.setNode(anchorPane);
					// 2. �迭�� �� �ֱ�
					series.getData().add(data);
			}
		// y�� ����
		lc.getYAxis().setAutoRanging(false); // y�� �ڵ����� ����
		
		lc.getData().add(series); // 4. �迭�� ��Ʈ�� �ֱ�
		
		// ���̺� ���� ����
		if(productDates.get(productDates.size()-1).getCount() > productDates.get(productDates.size()-2).getCount()) {
					// ����Ʈ�� ������ ��ü�� ��¥�� �� > ����Ʈ�� ������ �� ��ü�� ��¥�� ��
			lbldecrease.setVisible(false); // ���� ���̺� �����
		}else {
			lblincrease.setVisible(false); // ���� ���̺� �����
		}
		
		// bar ��Ʈ 
		XYChart.Series series2 = new XYChart.Series<>();
//		series2.setName("ȣ�ھ絵");
		// 1.
			HashMap<String , Integer> hashMap = ProductDao.getProductDao().productcategorylist();
			String maxcategorykey = " ";
			int max = 0;
			for(String key : hashMap.keySet()) {
				if(hashMap.get(key)> max) {
					max= hashMap.get(key);
					maxcategorykey = key;
					
				}
					// map�� ��ü Ű�� �����ͼ� �ݺ���
				XYChart.Data data = new XYChart.Data<>(key,hashMap.get(key));
				series2.getData().add(data);
				
			
			}
		bc.getData().add(series2);
		lblcategory.setText(maxcategorykey);
			
		// pie ��Ʈ
		ObservableList<Product> products = ProductDao.getProductDao().productlist();
		
		ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
		for(Product product : products) {
			observableList.add(new PieChart.Data(product.getActivation(), 1));
		}
		
		pc.setData(observableList);
		
		
		
		
		
		
		
		// 1. ��緹�ڵ� �˻�
		// select * from product
		// 2. p_date �ʵ� �������� ����
		// 		select substring_index(product.p_date ," ", 1) from product
		// 		*substring_index(�ʵ��, "���ر���" , �����ù�ȣ)
		//		*2021-11-08 13:40:35 	-> 	2021-11-08  	:1
		//									13:40:35		:2
		// 3. �׷� [group by �ʵ��]
		// GROUP BY select substring_index(product.p_date," ",1) from product
		// 4. �׷����� : [having: �׷쳻 ���� <-----> where�׷��� ����]
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
