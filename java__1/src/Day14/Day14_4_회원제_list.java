package Day14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14_4_회원제_list {

	
	// 회원제 프로그램
		// 1. list를 이용한 회원가입, 로그인 , 회원정보 , 회원수정 , 회원탈퇴
	public static void main(String[] args) {
		
		// 0.설정 [ 입력객체 ]
		Scanner scanner = new Scanner(System.in);
		// 0.설정 [ 리스트 선언 : User 클래스만 담을수 있는 클래스 ( User클래스의 하위도 가능 ) ]
		ArrayList<User> users = new ArrayList<>();
		// 0.설정 [ 파일 읽어오기 : 파일에 있는 회원들을 리스트에 저장 ]
			
		// 1.파일입력 클래스 
		try {
			FileInputStream fileInputStream =
					new FileInputStream("D:/JavaWeb/jihy1218/java__1/src/Day14/userlist.txt");
			// 1. 파일내 모든 글자 가져오기 [ 스트림 단위 : 바이트 ]
				// 1.바이트 배열 선언
				byte[] bytes = new byte[1024];	// 1bit -> 8bit -> 1byte -> 1024byte -> 1kb
						// 영문, 특수문자,공백 1바이트 // 한글 2바이트
				// 2.읽어오기
				fileInputStream.read(bytes);
				// 3. 바이트를 문자열로변환
				String inString = new String(bytes);
			// 2. 회원 구분하기
				String[] usersnum = inString.split("\n");
										// split(기준) 분리 => 배열
			// 3. 필드 구분하기
				for(String temp : usersnum) {
					String[] userdata = temp.split(",");
					if( userdata.length == 1 ) break;
						// 마지막 회원 (공백회원) 제외
					// 4. 객체 생성
					User user = new User(userdata[0], userdata[1], userdata[2]);
					// 5. 리스트 담기
					users.add(user);
				}
		}
		catch (Exception e) {
			System.out.println("[[파일 불러오기 실패]]");
		}

		// 1.메뉴
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			int ch = scanner.nextInt();
			if(ch==1) {
				// 1. 입력받기
				System.out.println("아이디 : "); 		String id = scanner.next();
				System.out.println("비밀번호 : "); 	String password = scanner.next();
				System.out.println("이름 : "); 		String name = scanner.next();
				// 2. 입력받은 데이터를 객체화 [ 3개의 변수를 하나의 객체를 하나로 사용 ]
				User user = new User(id, password, name);
					// 아이디 중복 체크 [ 리스트내 객체 하나씩 temp에 대입]
					boolean idcheck = true;
					for(User temp : users) {
						if(temp.getId().equals(id)) {
							System.out.println("[[중복된 아이디 입니다]]");
							idcheck=false; break;
						}
					}
 				// 3. 리스트에 저장 [ 만약에 중복값이 없으면 저장 ] 
				if(idcheck) { users.add(user); System.out.println("[[회원가입성공]]");
				// 4. 파일처리
					// 1. 파일출력 클래스 [ new FileOutputStream("파일경로/파일명.확장자"); 새로쓰기
					// 				 [ new FileOutputStream("파일경로/파일명.확장자" , true); 이어쓰기
					try {
						FileOutputStream fileOutputStream = 
								new FileOutputStream("D:/JavaWeb/jihy1218/java__1/src/Day14/userlist.txt" ,true);
						// 2. 필드간 구분 [,] // 회원간 구분 [\n]
						String outString = user.getId()+","+user.getPassword()+","+user.getName()+"\n";
						// 3. String ----> bytes 내보내기[ write(바이트열)]
						fileOutputStream.write(outString.getBytes());
					
						System.out.println("[[ 파일 처리 성공 ]]");
					
					} catch (Exception e) {
						System.out.println("[[파일처리 실패]]");
					}
				
				
				}
				
			}
			else if( ch==2 ) {
				// 1. 입력받기
				System.out.println("아이디 : "); 	String id = scanner.next();
				System.out.println("비밀번호 : "); 	String password = scanner.next();
				// 2. 리스트내 객체와 비교하기 
				boolean logincheck = true;
				for(User temp : users) {
					if(temp.getId().equals(id)&&temp.getPassword().equals(password)) {
						System.out.println("[[로그인 성공]]");
						logincheck=false; 
						
						/////////////로그인 성공시///////////
						while(true) { //  회원메뉴 무한루프
							System.out.println("1.회원정보 2. 회원수정 3. 회원탈퇴 4.로그아웃");
							int ch1 = scanner.nextInt();
							
							if(ch1==1) { 
								System.out.println("아이디 : " + temp.getId());
								System.out.println("성명 : " + temp.getName());					
							}else if(ch1==2) {
								// 1. 수정할 정보 입력
								System.out.println("수정할 성명 : " ); String newname = scanner.next(); 
								// 2. set 메소들르 통한 필드 값 변경
								temp.setName(newname);
								// 파일 업데이트 처리
								// 
								try {
									// 파일 출력 객체 생성 ( 파일경로 )
									FileOutputStream fileOutputStream 
											= new FileOutputStream("D:/JavaWeb/jihy1218/java__1/src/Day14/userlist.txt");
									
									// 1. 리스트내 모든 회원 저장 [ 업데이트 ]
									String outString = ""; // 모든 회원의 정보를 담을 문자열
									for(User temp2 : users) {
										// 회원 분류
										String outtemp = temp2.getId()+","+temp2.getPassword()+","+temp2.getName()+"\n";
										// 분류된 정보를 모든회원 문자열에 추가
										outString += outtemp;
									}
									// 모든 회원 내보내기
									fileOutputStream.write(outString.getBytes());
									
									
								} catch (Exception e) {
									
									
								}
								
							}else if(ch1==3) {
								// 1. 리스트에서 객체 삭제
								users.remove(temp);
								System.out.println("[[회원탈퇴:로그아웃]]");
								// 파일 업데이트 처리
								try {
									// 파일 출력 객체 생성 ( 파일경로 )
									FileOutputStream fileOutputStream 
											= new FileOutputStream("D:/JavaWeb/jihy1218/java__1/src/Day14/userlist.txt");
									
									// 1. 리스트내 모든 회원 저장 [ 업데이트 ]
									String outString = ""; // 모든 회원의 정보를 담을 문자열
									for(User temp2 : users) {
										// 회원 분류
										String outtemp = temp2.getId()+","+temp2.getPassword()+","+temp2.getName()+"\n";
										// 분류된 정보를 모든회원 문자열에 추가
										outString += outtemp;
									}
									// 모든 회원 내보내기
									fileOutputStream.write(outString.getBytes());
									
									
								} catch (Exception e) {
									
									
								}
								break;
								
							}else if(ch1==4) {
								System.out.println("[[로그아웃]]"); break;
							}						
						} 
							break;
					}
				}
				if(logincheck) { System.out.println("[[동일한 회원정보가 없습니다 ]]"); }
	
			}
		}
	}
}
