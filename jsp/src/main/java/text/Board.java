package text;

public class Board {
	
	// 필드 
	private String title;
	private String contents;
	private String writer;
	// 생성자
	public Board() {}
	
	public Board(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}

	
	
	// 메소드 
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getContents() {return contents;}
	public void setContents(String contents) {this.contents = contents;}
	public String getWriter() {return writer;}
	public void setWriter(String writer) {this.writer = writer;}
}
