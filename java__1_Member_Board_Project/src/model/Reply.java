package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	
	// 필드
	private String writer;
	private String contents;
	private String date;
	
	// 생성자
	public Reply() {
		
	}

	public Reply(String writer, String contents) {
		this.writer = writer;
		this.contents = contents;
		Date date = new Date(); // 현재 시간 클래스
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		this.date = simpleDateFormat.format(date);
	}

	// 메소드
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
