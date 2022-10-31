package abstractexample;

abstract class Animal {
	String name;
	
	// default constructor
	public Animal() {
		this("미입력");
	}
	
	// 1 argument - constructor
	public Animal(String name) {
		this.name = name;
	}
	
	// abstract method
	public abstract void play();
	
}

class Cat extends Animal {
	
	public Cat() {
		this("미입력");
	}

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println(name + "는 낚싯대 놀이 중입니다.");
	}
	
}

class Dog extends Animal {

	public Dog() {
		this("미입력");
	}
	
	public Dog(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println(name + "는 터그 놀이 중입니다.");
	}
	
}

public class AbstractQuiz {

	public static void animalPlay(Animal name) {
		System.out.println(name);
	}
	
	public static void main(String[] args) {

		Dog roy = new Dog("로이");
		Cat bear = new Cat("베어");
		
		animalPlay(roy);		// 로이는 터그 놀이 중입니다.
		animalPlay(bear);		// 베어는 낚싯대 놀이 중입니다.
		
	}


}
