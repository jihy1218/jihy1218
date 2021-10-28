package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Board {

	// 필드
	private String title;
	private String contents;
	private String writer;
	private String date;
	private int view;
	// 하나의 게시물에 여러개 댓글 저장하기 위한 
	private  ArrayList<Reply> replylist;
	
	// 생성자
	public Board() { // 빈생성자 : 1. 메소드호출용 2. 빈 객체 생성후 추후에 필드에 값 대입할때
	
	}

	public Board(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		Date date = new Date(); // 현재 시간 클래스
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		this.date = simpleDateFormat.format(date);
		this.view = 1;
		this.replylist = new ArrayList<Reply>(); // 댓글 메소드 메모리 할당
	}
	// 파일 로드시 사용되는 생성자
	public Board(String title, String contents, String writer, String date, int view) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.replylist = new ArrayList<Reply>();
	}

	// 메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public ArrayList<Reply> getReplylist() {
		return replylist;
	}

	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}
	
	
	
}
