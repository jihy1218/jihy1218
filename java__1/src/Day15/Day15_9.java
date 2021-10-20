package Day15;

import java.util.Iterator;
import java.util.TreeSet;

public class Day15_9 {

	public static void main(String[] args) {
		
		TreeSet<Person> treeset = new TreeSet<Person>();
		
		treeset.add(new Person("홍길동" , 45));
		treeset.add(new Person("김자바" , 25));
		treeset.add(new Person("박지원" , 31));
		
		// 3. 나이순으로 
		Iterator<Person> iterator = treeset.iterator();
		while( iterator.hasNext()) {
			Person person =iterator.next();
			System.out.println(person.name + "\t"+ person.age);
		}
		// 3
		for(Person person : treeset) {
			System.out.println(person.name + "\t"+ person.age);
		}
		
	}
}
