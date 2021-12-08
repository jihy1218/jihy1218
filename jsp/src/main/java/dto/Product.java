package dto;

public class Product {

	// 필드
	private int p_num;			// 제품번호
	private String p_name;		// 제품 이름
	private int p_price;		// 제품 가격
	private int p_hp;			// 제품 마력
	private int p_cc;			// 제품 CC
	private int p_mileage;		// 제품 연비
	private String p_fueltype;	// 가솔린, 디젤
	private String p_img;		// 제품 이미지
	private int p_count;		// 제품 재고
	private String p_category;	// 제품 카테고리
	private int p_activation;	// 제품 활성화 상태
	private String p_detail; 	// 제품 상세정보
	private String p_date;  	// 제품 등록일
	private int p_view;			// 제품 조회수
	private int p_like;			// 제품 좋아요수	
	
	// 생성자
	public Product() {} // 빈 생성자
	
	// 풀생성자
	public Product(int p_num, String p_name, int p_price, int p_hp, int p_cc, int p_mileage, String p_fueltype,
			String p_img, int p_count, String p_category, int p_activation, String p_detail, String p_date, int p_view,
			int p_like) {
		this.p_num = p_num;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_hp = p_hp;
		this.p_cc = p_cc;
		this.p_mileage = p_mileage;
		this.p_fueltype = p_fueltype;
		this.p_img = p_img;
		this.p_count = p_count;
		this.p_category = p_category;
		this.p_activation = p_activation;
		this.p_detail = p_detail;
		this.p_date = p_date;
		this.p_view = p_view;
		this.p_like = p_like;
	}

	// 제품 등록시 생성자
	
	
	// get, set 메소드
	public int getP_num() {return p_num;}
	public void setP_num(int p_num) {this.p_num = p_num;}
	public String getP_name() {return p_name;}
	public void setP_name(String p_name) {this.p_name = p_name;}
	public int getP_price() {return p_price;}
	public void setP_price(int p_price) {this.p_price = p_price;}
	public int getP_hp() {return p_hp;}
	public void setP_hp(int p_hp) {this.p_hp = p_hp;}
	public int getP_cc() {return p_cc;}
	public void setP_cc(int p_cc) {this.p_cc = p_cc;}
	public int getP_mileage() {return p_mileage;}
	public void setP_mileage(int p_mileage) {this.p_mileage = p_mileage;}
	public String getP_fueltype() {return p_fueltype;}
	public void setP_fueltype(String p_fueltype) {this.p_fueltype = p_fueltype;}
	public String getP_img() {return p_img;}
	public void setP_img(String p_img) {this.p_img = p_img;}
	public int getP_count() {return p_count;}
	public void setP_count(int p_count) {this.p_count = p_count;}
	public String getP_category() {	return p_category;}
	public void setP_category(String p_category) {this.p_category = p_category;}
	public int getP_activation() {return p_activation;}
	public void setP_activation(int p_activation) {this.p_activation = p_activation;}
	public String getP_detail() {return p_detail;}
	public void setP_detail(String p_detail) {this.p_detail = p_detail;}
	public String getP_date() {return p_date;}
	public void setP_date(String p_date) {this.p_date = p_date;}
	public int getP_view() {return p_view;}
	public void setP_view(int p_view) {this.p_view = p_view;}
	public int getP_like() {return p_like;}
	public void setP_like(int p_like) {this.p_like = p_like;}
}
