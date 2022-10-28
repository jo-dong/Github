package polymorphism;

class Fruit {
	
	@Override
	public String toString() {
		return "Fruit!";
	}
	
}

class Person {
	
	@Override
	public String toString() {
		return "Person!";
	}
	
}

public class Ex03 {
	
	// Object로 polymorphism 구현
	public static void printInfo(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {

		Fruit f = new Fruit();
		Person p = new Person();
		
		printInfo(f);
		printInfo(p);
		
	}

}
