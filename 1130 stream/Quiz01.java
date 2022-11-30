package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Quiz01 {
	public static void main(String[] args) {

		Student[] student = {new Student("하루", 25), new Student("마루", 22)};
		List<Student> list = Arrays.asList(student);
		
		// [Q1] Enhanced for-loop : 이름과 나이 출력
		// [출력 형태] 이름 : 하루, 나이 : 25
		//			  이름 : 마루, 나이 : 22
		System.out.println("[Quiz 1]");
		for(Student s : list)
			System.out.println("이름 : " + s.getName() + ", 나이 : " + s.getAge());
		
		// [Q2-1] Stream : 이름만 출력
		// [출력 형태] 하루
		//			  마루
		System.out.println("[Quiz 2-1]");
		Stream<Student> name = list.stream();
		name.forEach(t -> System.out.println(t.getName()));
		name.close();
		
		// [Q2-1] Stream : 이름, 나이를 따로 출력
		// [출력 형태] 이름 : 하루, 나이 : 25
		//			  이름 : 마루, 나이 : 22
		System.out.println("[Quiz 2-2]");
		Stream<Student> nameAge = list.stream();
		nameAge.forEach(t -> System.out.println("이름 : " + t.getName() + 
												", 나이 : " + t.getAge()));
		nameAge.close();
	}

}
