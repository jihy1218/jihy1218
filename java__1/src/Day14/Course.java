package Day14;

public class Course <T>{

	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		students = (T[])new Object[capacity];
			// 제네릭 자체적으로 NEW 연산자 불가 
			// object 으로 배열 선언후 제네릭으로 형변환
	}

	public String getName() {return name;}
	public T[] getStudents() {return students;}

	public void add(T t) {
		for(int i = 0 ; i<students.length ; i++) {
			if(students[i]==null) {
				students[i] = t; break;
				
			}
		}
	}
	
	
	
	
}
