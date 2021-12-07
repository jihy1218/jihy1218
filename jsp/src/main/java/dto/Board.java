package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.MemberDao;

public class Board {

	// 필드
	private int b_num;
	private String b_title;
	private String b_contents;
	private int m_num;
	private String b_date;
	private String b_file;
	private String b_file2;
	private int b_view;
	private int b_activation;
	private String b_writer;
	
	// 생성자
	public Board() {} // 빈 생성자

		// 풀 생성자
	public Board(int b_num, String b_title, String b_contents, int m_num, String b_date, String b_file, String b_file2 ,int b_view,
			int b_activation) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.m_num = m_num;
		this.b_date = b_date;
		Date today = new Date();
		// 등록날짜와 오늘 날짜가 동일하면 시간 아니면 날짜 표시
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	// 날짜+시간 형식
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");				// 날짜 형식
		SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");					// 시간 형식
		try {
			Date date = datetimeFormat.parse(b_date);			
			if(dateFormat.format(date).equals(dateFormat.format(today))) {		// 등록날짜 = 
				this.b_date= timeformat.format(date);		// 날짜가 동일하면 시간 출력
			}else {
				this.b_date = dateFormat.format(date);		// 날짜가 동일하지 않으면 날짜 출력
			}
		} catch (Exception e) {	}
		this.b_file = b_file;
		this.b_file2 = b_file2;
		this.b_view = b_view;
		this.b_activation = b_activation;
		this.b_writer = MemberDao.getmemberDao().getmemberid(m_num);
	}
		// 게시물등록시 필요한 생성자
	public Board(String b_title, String b_contents, int m_num, String b_file , String b_file2) {
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.m_num = m_num;
		this.b_file = b_file;
		this.b_file2 = b_file2;
	}
		// 수정용 생성자
	public Board(int b_num, String b_title, String b_contents, String b_file, String b_file2) {
			this.b_num = b_num;
			this.b_title = b_title;
			this.b_contents = b_contents;
			this.b_file = b_file;
			this.b_file2 = b_file2;
		}
	// 메소드
	public int getB_num() {return b_num;}
	public void setB_num(int b_num) {this.b_num = b_num;}
	public String getB_title() {return b_title;}
	public void setB_title(String b_title) {this.b_title = b_title;}
	public String getB_contents() {return b_contents;}	
	public void setB_contents(String b_contents) {this.b_contents = b_contents;}
	public int getM_num() {return m_num;}
	public void setM_num(int m_num) {this.m_num = m_num;}
	public String getB_date() {return b_date;}
	public void setB_date(String b_date) {this.b_date = b_date;}
	public String getB_file() {return b_file;}
	public void setB_file(String b_file) {this.b_file = b_file;}
	public String getB_file2() {return b_file2;}
	public void setB_file2(String b_file2) {this.b_file2 = b_file2;}
	public int getB_view() {return b_view;}
	public void setB_view(int b_view) {this.b_view = b_view;}
	public int getB_activation() {return b_activation;}
	public void setB_activation(int b_activation) {this.b_activation = b_activation;}
	public String getB_writer() {return b_writer;}
	public void setB_writer(String b_writer) {this.b_writer = b_writer;}
}
