package Day14;

import java.util.Arrays;

public class Day14_2 {

	public static void main(String[] args) {
		
		// 제네릭
			// 1. 자체적으로 new 연산자 불가
		
		// 19번줄
		Course<Person> personCourse = new Course<Person>("일반인과정", 5);
			// Person 클래스로 배열을 선언
			personCourse.add(new Person("일반인"));
			personCourse.add(new Worker("직장인"));
			personCourse.add(new Student("학생"));
			personCourse.add(new HighStudent("고등학생"));
			// 해당배열의 add는 일반인, 직장인, 학생 , 고등학생
			
		Course<Worker> workerCourse = new Course <Worker>("직장인과정" , 5);
		//	workerCourse.add(new Person("일반인"));
			workerCourse.add(new Worker("직장인"));
		//	workerCourse.add(new Student("학생"));
		//	workerCourse.add(new HighStudent("고등학생"));
				// Worker 클래스로 배열이 생성
				// 해당 배열에 add는 직장인
		
		Course<Student> studentCourse = new Course <Student>("학생과정" , 5);
		//	studentCourse.add(new Person("일반인"));
		//	studentCourse.add(new Worker("직장인"));
			studentCourse.add(new Student("학생"));
			studentCourse.add(new HighStudent("고등학생"));
				// Student 클래스로 배열이 생성
				// 해당 배열에 add는 학생, 고등학생
		Course<HighStudent> highstudentCourse = new Course <HighStudent>("고등학생과정" , 5);
		//	highstudentCourse.add(new Person("일반인"));
		//	highstudentCourse.add(new Worker("직장인"));
		//	highstudentCourse.add(new Student("학생"));
			highstudentCourse.add(new HighStudent("고등학생"));
				// HighStudent 클래스로 배열이 생성
				// 해당 배열에 add는 고등학생
		// 모두 등록 가능	
		System.out.println("=========Course<?> : 모든 코스 가능 =============");
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highstudentCourse);
		System.out.println();
		// 학생 과정만 등록가능
		System.out.println("=========Course<? extends 클래스 > : 클래스로부터 자식클래스만 가능 =============");
		//registerCourseStudent(personCourse);
		//registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highstudentCourse);
		System.out.println();
		// 직장인과 일반인 과정만 등록가능
		System.out.println("=========Course<? super 클래스 > : 클래스로부터 부모클래스만 가능 =============");
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		//registerCourseWorker(studentCourse);
		//registerCourseWorker(highstudentCourse);
			
	} // main 끝
	
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생명단 : "+
				Arrays.toString(course.getStudents()));
	}
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생명단 : "+
				Arrays.toString(course.getStudents()));
		
	}
	// 직장인 목록을 호출하는 메소드 
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생명단 : "+
				Arrays.toString(course.getStudents()));
		
	}
}
