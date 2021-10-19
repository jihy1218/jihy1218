package Day14;

import java.util.Arrays;

public class Day14_2 {

	public static void main(String[] args) {
		
		// ���׸�
			// 1. ��ü������ new ������ �Ұ�
		
		// 19����
		Course<Person> personCourse = new Course<Person>("�Ϲ��ΰ���", 5);
			// Person Ŭ������ �迭�� ����
			personCourse.add(new Person("�Ϲ���"));
			personCourse.add(new Worker("������"));
			personCourse.add(new Student("�л�"));
			personCourse.add(new HighStudent("����л�"));
			// �ش�迭�� add�� �Ϲ���, ������, �л� , ����л�
			
		Course<Worker> workerCourse = new Course <Worker>("�����ΰ���" , 5);
		//	workerCourse.add(new Person("�Ϲ���"));
			workerCourse.add(new Worker("������"));
		//	workerCourse.add(new Student("�л�"));
		//	workerCourse.add(new HighStudent("����л�"));
				// Worker Ŭ������ �迭�� ����
				// �ش� �迭�� add�� ������
		
		Course<Student> studentCourse = new Course <Student>("�л�����" , 5);
		//	studentCourse.add(new Person("�Ϲ���"));
		//	studentCourse.add(new Worker("������"));
			studentCourse.add(new Student("�л�"));
			studentCourse.add(new HighStudent("����л�"));
				// Student Ŭ������ �迭�� ����
				// �ش� �迭�� add�� �л�, ����л�
		Course<HighStudent> highstudentCourse = new Course <HighStudent>("����л�����" , 5);
		//	highstudentCourse.add(new Person("�Ϲ���"));
		//	highstudentCourse.add(new Worker("������"));
		//	highstudentCourse.add(new Student("�л�"));
			highstudentCourse.add(new HighStudent("����л�"));
				// HighStudent Ŭ������ �迭�� ����
				// �ش� �迭�� add�� ����л�
		// ��� ��� ����	
		System.out.println("=========Course<?> : ��� �ڽ� ���� =============");
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highstudentCourse);
		System.out.println();
		// �л� ������ ��ϰ���
		System.out.println("=========Course<? extends Ŭ���� > : Ŭ�����κ��� �ڽ�Ŭ������ ���� =============");
		//registerCourseStudent(personCourse);
		//registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highstudentCourse);
		System.out.println();
		// �����ΰ� �Ϲ��� ������ ��ϰ���
		System.out.println("=========Course<? super Ŭ���� > : Ŭ�����κ��� �θ�Ŭ������ ���� =============");
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		//registerCourseWorker(studentCourse);
		//registerCourseWorker(highstudentCourse);
			
	} // main ��
	
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " ��������� : "+
				Arrays.toString(course.getStudents()));
	}
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " ��������� : "+
				Arrays.toString(course.getStudents()));
		
	}
	// ������ ����� ȣ���ϴ� �޼ҵ� 
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " ��������� : "+
				Arrays.toString(course.getStudents()));
		
	}
}
