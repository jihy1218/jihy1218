package Day13;

import java.util.Scanner;

public class Day13_����2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean sw = true;
		boolean sw2 = true;
		while(true) {
			System.out.println("===========�޴�===========");
			System.out.println("1.������� || 2 .��ȭ���");
			System.out.print(">> ���� : "); int ch = scanner.nextInt();
			
			if(ch==1) {	
				Thread therad = new Music();
				
				if(sw) {
					Music.musicstop(sw);
					therad.start();	
					sw=false;
				}else {
					Music.musicstop(sw);
					sw =true;
				}
			}else if(ch==2) {	
				Thread thread = new Movie();
				
				if(sw2) {
					Movie.moviestop(sw2);
					thread.start();
					sw2=false;
				}else {
					Movie.moviestop(sw2);
					sw2=true;
				}
			}
		}
		
		// Ȯ�ι��� p.648
			// 1. �� 4
			// 2. : new MusicRunnable()
			//		extends Thread
			//		implements Runnable
			// 3. �� 4 [1�� ���� ���� �켱����]
			// 4. �� 2 [wait �� �ɸ��� ȣ���Ҽ� �ִ�]
			// 5. �� 4 [yield() ������ ȣ�� : ������ �纸()]
			// 6. �� 4 [ȣ���� �����尡 �Ͻ�����]
			// 7. �� 2 [��� ���� X]
			// 8.
				// 
				// if(Thread.interrupted){break;}
				//
			// 10. main �����尡 ����� �ٸ� ������ ���� [ thread.setDaemon(true) ]
			// 11. �� 1 stop()�� �ּ��� ����� �ƴ�
		
		
		
		
	}
}
