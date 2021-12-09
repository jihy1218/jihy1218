package dto;

import java.text.DecimalFormat;

public class Product {

	// 필드
	private int p_num;			// 제품번호
	private String p_name;		// 제품 이름
	private int p_price;		// 제품 가격
	private int p_cc;			// 제품 CC
	private String p_fueltype;	// 가솔린, 디젤
	private String p_img;		// 제품 이미지
	private int p_stock;		// 제품 재고
	private String p_category;	// 제품 카테고리
	private int p_active;	// 제품 활성화 상태
	private String p_contents; 	// 제품 상세정보
	private String p_date;  	// 제품 등록일

	public String getprice(int p_price) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(p_price);
	}
	public String getactive(int p_active) {
		if(this.p_active==1) {return "준비중";}
		if(this.p_active==2) {return "판매중";}
		if(this.p_active==3) {return "품절";}
		return null;
	}
	// 생성자
	public Product() {} // 빈 생성자
	
	// 풀생성자
	public Product(int p_num, String p_name, int p_price, int p_cc, String p_fueltype,String p_img, int p_stock, String p_category,
					int p_active, String p_contents, String p_date) {
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_cc = p_cc;
		this.p_fueltype = p_fueltype;
		this.p_img = p_img;
		this.p_stock = p_stock;
		this.p_category = p_category;
		this.p_active = p_active;
		this.p_contents = p_contents;
		this.p_date = p_date;
	}

	// 제품 등록시 생성자
	public Product(String p_name, int p_price, int p_cc, String p_fueltype, String p_img, int p_stock,
			String p_category, int p_active, String p_contents) {
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_cc = p_cc;
		this.p_fueltype = p_fueltype;
		this.p_img = p_img;
		this.p_stock = p_stock;
		this.p_category = p_category;
		this.p_active = p_active;
		this.p_contents = p_contents;
	}

	// 제품수정시 생성자
	public Product(int p_num, String p_name, int p_price, int p_cc, String p_fueltype, String p_img, int p_stock,
			String p_category, String p_contents) {
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_cc = p_cc;
		this.p_fueltype = p_fueltype;
		this.p_img = p_img;
		this.p_stock = p_stock;
		this.p_category = p_category;
		this.p_contents = p_contents;
	}
	
	// get, set 메소드
	public int getP_num() {return p_num;}
	public void setP_num(int p_num) {this.p_num = p_num;}
	public String getP_name() {return p_name;}
	public void setP_name(String p_name) {this.p_name = p_name;}
	public int getP_price() {return p_price;}
	public void setP_price(int p_price) {this.p_price = p_price;}
	public int getP_cc() {return p_cc;}
	public void setP_cc(int p_cc) {this.p_cc = p_cc;}
	public String getP_fueltype() {return p_fueltype;}
	public void setP_fueltype(String p_fueltype) {this.p_fueltype = p_fueltype;}
	public String getP_img() {return p_img;}
	public void setP_img(String p_img) {this.p_img = p_img;}
	public int getP_stock() {return p_stock;}
	public void setP_stock(int p_stock) {this.p_stock = p_stock;}
	public String getP_category() {	return p_category;}
	public void setP_category(String p_category) {this.p_category = p_category;}
	public int getP_active() {return p_active;}
	public void setP_active(int p_active) {this.p_active = p_active;}
	public String getP_contents() {return p_contents;}
	public void setP_contents(String p_contents) {this.p_contents = p_contents;}
	public String getP_date() {return p_date;}
	public void setP_date(String p_date) {this.p_date = p_date;}
	
}