package Day11;

import java.io.IOException;
public class BookApplication {


	public static void main(String[] args) throws IOException {
		String[] booklist = { "된다!네이버 블로그&포스트", "스프링 루트 실천 활용 마스터", "Tucker의 Go 언어 프로그래밍", "혼자 공부하는 C 언어"};
		
		while(true) {
			
		System.out.println("1.검색|2.수정");
		System.out.print(">>입력 : ");
			// 바이트배열 선언 [ 키보드로부터 입력받은 바이트를 저장할 배열 ]
		byte[] b = new byte[100]; // 넉넉히 100바이트 [ 영문이면 100글자 한글이면 50글자 ]
		// 바이트 --> 문자열 변환
		int count = System.in.read(b);
		String ch= new String(b, 0, count-2); // 바이트 => 문자열 -2 하는이유 [ \n , \r ]
		
		
		if(ch.equals("1")) {  	
			System.out.println("검색어를 입력하세요 >> : "); int count1 = System.in.read(b);
			
			String book= new String(b, 0, count1-2);
			for(int i = 0 ; i<booklist.length; i++) {
				// 도서명이 포함된 단어 일치했을경우
				if(booklist[i].contains(book)) {
					System.out.println(booklist[i]);
				}
				if(booklist[i].indexOf(book) != -1) {
					System.out.println(booklist[i]);
				}
				
			}
		}
		
		else if(ch.equals("2")) {
			System.out.println("검색도서를 입력하세요 >> : "); int book = System.in.read(b);
			String ch2= new String(b, 0, book-2);
			for(int i = 0 ; i<booklist.length; i++ ) {
				if(booklist[i].contains( ch2 )) {
					System.out.println(i+"번"+booklist[i]);
				}
			}
			System.out.println("수정할 도서 번호 : ");
			int book1 = System.in.read(b);
			int ch3= Integer.parseInt(new String(b, 0, book1-2));
			
			System.out.println("변경할 문자 : ");
			book1 = System.in.read(b);
			String oldbook= new String(b, 0, book1-2);
			
			System.out.println("새로운 문자 : ");
			book1 = System.in.read(b);
			String newbook= new String(b, 0, book1-2);
			 
			//치환
			
			booklist[ch3]=booklist[ch3].replace(oldbook, newbook); 
		}
		
		
		
		
		}
	
		
		}

	}


