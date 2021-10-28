package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
	
	// �ʵ�
	private String writer;
	private String contents;
	private String date;
	
	// ������
	public Reply() {
		
	}

	public Reply(String writer, String contents) {
		this.writer = writer;
		this.contents = contents;
		Date date = new Date(); // ���� �ð� Ŭ����
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		this.date = simpleDateFormat.format(date);
	}

	// �޼ҵ�
	
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
