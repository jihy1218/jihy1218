package Day09;

public class Parent {
	
	public String nation;
	
	public Parent() {
		this("대한민국");	// 현재 클래스내 생산자
		System.out.println("Parent() call");
	}
	public Parent( String nation ) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
