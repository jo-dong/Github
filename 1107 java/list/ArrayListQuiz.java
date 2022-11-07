package list;

import java.util.ArrayList;
import java.util.Iterator;

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// setter, getter 추가
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class ArrayListQuiz {

	public static void main(String[] args) {

		Person hong = new Person("홍길동", 25);
		Person park = new Person("박보검", 35);
		
		// ArrayList 생성
		ArrayList<Person> array = new ArrayList<Person>();
		
		// Element 추가
		array.add(hong);
		array.add(park);
		array.add(new Person("이미자", 52));
		
		Person lee = new Person("이미자", 52);
		
		// Q1
		System.out.println("<< 저장된 이름 전체 출력 >>");
		for(Person arr : array)
			System.out.println(arr.getName());
		
		// Q2
		System.out.println("\n<< 저장된 전체 Element 개수 >>");
		System.out.println(array.size());
		
		// Q3
		System.out.println("\n<< index=1의 이름 >>");
		System.out.println(array.get(1).getName());
		
		// Q4
		System.out.println("\n<< 35세 박보검 포함 여부 >>");
		System.out.println(array.contains(park));
		
		// Q5
		System.out.println("\n<< 52세 이미자 포함 여부 >>");
		System.out.println(array.contains("이미자"));
		System.out.println(array.contains(lee));		// 둘 다 false
		
		// Q6
		System.out.println("\n<< 홍길동 이름을 화이팅으로 변경 >>");
		Iterator<Person> iter = array.iterator();
		hong.setName("화이팅");
//		array.set(0, hong.setName("화이팅"));
		while(iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
		
	}


}
