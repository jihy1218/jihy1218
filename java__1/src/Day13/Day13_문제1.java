package Day13;

public class Day13_����1 {

	public static void main(String[] args) {
		
		DogSound dogSound = new DogSound();
		CatSound catSound = new CatSound();
		TigarSound tigarSound = new TigarSound();
		dogSound.start();
		catSound.start();
		tigarSound.start();
		
		try {Thread.sleep(6000);} 
		catch (Exception e) {}
		System.out.println(" ������ �� : " + dogSound.getName());
		System.out.println(" ������ �� : " + catSound.getName());
		System.out.println(" ������ �� : " + tigarSound.getName());
	}
}
