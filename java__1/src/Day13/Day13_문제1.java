package Day13;

public class Day13_문제1 {

	public static void main(String[] args) {
		
		DogSound dogSound = new DogSound();
		CatSound catSound = new CatSound();
		TigarSound tigarSound = new TigarSound();
		dogSound.start();
		catSound.start();
		tigarSound.start();
		
		try {Thread.sleep(6000);} 
		catch (Exception e) {}
		System.out.println(" 스레드 명 : " + dogSound.getName());
		System.out.println(" 스레드 명 : " + catSound.getName());
		System.out.println(" 스레드 명 : " + tigarSound.getName());
	}
}
