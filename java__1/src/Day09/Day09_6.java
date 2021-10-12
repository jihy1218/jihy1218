package Day09;

public class Day09_6 {

	public static Menu[] menulist = new Menu[100];
	
	public static void main(String[] args) {
		// 인터페이스 생성
		Enrolment enrolment;
		// 인터페이스 클래스 연결
		enrolment = new Student();
		// 인터페이스로부터 클래스 조작
		enrolment.로그인();
		enrolment.수강신청();
		enrolment.수강신청목록();
		enrolment.수강신청취소();
		// 인터페이스내 클래스 변경
		enrolment = new Admin();
		enrolment.로그인();
		enrolment.수업등록();
		enrolment.수업등록목록();
		
		//슈퍼클래스로 배열 선언
		Menu login1 = new Menu();
		menulist[0] = login1;
		
		Student login2 = new Student();
		menulist[1] = login2;
		
		Admin login3 = new Admin();
		menulist[2] = login3;
		
	}
}
