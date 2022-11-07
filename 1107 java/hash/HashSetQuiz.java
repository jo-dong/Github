
/*
 * [hashCode()를 Overriding 할 때 2가지 조건]
 * 1. 실행 중인 애플리케이션 내의 동일한 객체에 여러번 hashCode()를 호출해도 동일한 값을 리턴해야함
 * 2. equals() 메서드를 이용한 비교에 의해서 true를 얻은 두 객체에 대해 
 * 	  각각 hashCode()를 호출해서 얻은 결과는 반드시 같아야 한다.
 */

package hash;

import java.util.HashSet;
import java.util.Iterator;

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// setter, getter
	public String getName() {
		return this.name;
	}
	
	// overriding : hashCode()
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		return (person.name == this.name);
//		return (person.name == this.name && person.age == this.age);	// 이름, 나이를 같이 비교해야할 때 코드
		
	}
	
	// overriding : equals()
	@Override
	public int hashCode() {
		return this.name.hashCode();
//		return (this.name + this.age).hashCode();		// 이름, 나이를 같이 비교해야할 때 코드
	}
	
}

public class HashSetQuiz {

	public static void main(String[] args) {

		Person hong = new Person("홍길동", 25);
		Person park = new Person("박보검", 25);
		
		// HashSet 생성
		HashSet<Person> hashSet = new HashSet<Person>();
		
		// 요소 추가
		hashSet.add(hong);
		hashSet.add(park);
		hashSet.add(new Person("이미자", 52));
		
		// 전체 요소 출력
		System.out.println("<< 전체 요소 출력 >>");
		System.out.println("---- iterator() 사용 ----");
		Iterator<Person> iter = hashSet.iterator();
		while(iter.hasNext())
			System.out.println(iter.next().getName());
		
		// 새 요소 추가 : 이미자
		hashSet.add(new Person("이미자", 52));
		
		// 전체 요소 출력
		System.out.println("\n<< 전체 요소 출력 >>");
		System.out.println("---- toArray() 사용 ----");
		for(Object str : hashSet.toArray())
			System.out.println(((Person) str).getName());
		
	}

}
