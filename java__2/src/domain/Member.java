package domain;

import java.util.Properties;

public class Member {

	// 1. 필드
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private int m_point;
	// 2. 생성자
		// 1. 빈 생성자
	public Member() {}
	// 2. 모든 필드를 받는 생성자 [DB/File에서 꺼내올때 사용되는 생성자]
	public Member(String m_id, String m_password, String m_name, String m_email, int m_point) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_point = m_point;
	}
	// 3. 회원가입시 사용되는 생성자 [ 포인트를 제외 => 초기값 ]
	public Member(String m_id, String m_password, String m_name, String m_email) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_point = 1000;
	}
	// 4. 회원수정시 사용되는 생성자
	public Member(String m_name, String m_email) {
		this.m_name = m_name;
		this.m_email = m_email;
	}
	// 3. 메소드
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public int getM_point() {
		return m_point;
	}
	public void setM_point(int m_point) {
		this.m_point = m_point;
	}
	
	// email 전송 메소드
	public static void sendmail(String tomail , String msg , int type) {
		// 보낸사람 정보			// 받는사람 // 메일내용 // 메일타입
		String fromemail = "kimji1218@naver.com";
		String frompassword = "";
		
		Properties properties = new Properties();
	}
	
	
}
