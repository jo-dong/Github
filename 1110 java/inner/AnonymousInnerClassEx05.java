package inner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

class Person {
	// member field
	String name;
	int age;

	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	// member method
	public void showInfo() {
		System.out.printf("이름 : %s, 나이 : %d\n", name, age);
	}
	
}

public class AnonymousInnerClassEx05 {

	public static void main(String[] args) {
		
		HashSet<Person> hashSet = new HashSet<Person>();
		hashSet.add(new Person("박보검", 35));
		hashSet.add(new Person("이미자", 21));
		hashSet.add(new Person("홍길동", 25));
		hashSet.add(new Person("조동현", 28));
		
		// 출력
		Iterator<Person> iter = hashSet.iterator();
		while(iter.hasNext())
			iter.next().showInfo();
		
		// white space
		System.out.println();
		
		// [문제] - 이름(오름차순으로 정렬)
		// [문제 1-1] Comparator interface 구현 : Anonymous Class
		Comparator<Person> comparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return (p1.getName()).compareTo(p2.getName());
			}
		};
		// [문제 1-2] ArrayList로 변환
		ArrayList<Person> person = new ArrayList<Person>(hashSet);
		
		// [문제 1-3] 오름차순 정렬
		person.sort(comparator);
		for(Person p : person)
			p.showInfo();
		
	}

}
