package dto;

public class Cart {

	// 필드
	private int p_num;
	private String p_type;
	private int p_count;
	
	// 빈 생성자
	public Cart() { }

	// 풀 생성자
	public Cart(int p_num,String p_type, int p_count) {
		this.p_num = p_num;
		this.p_type = p_type;
		this.p_count = p_count;
	}

	// get, set 메소드
	public int getP_num() {return p_num;}
	public void setP_num(int p_num) {this.p_num = p_num;}
	public String getP_type() {return p_type;}
	public void setP_type(String p_type) {this.p_type = p_type;}
	public int getP_count() {return p_count;}
	public void setP_count(int p_count) {this.p_count = p_count;}
	
}
