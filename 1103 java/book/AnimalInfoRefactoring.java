package book;

public class AnimalInfoRefactoring {

	private String name;
	private int age;
	
	// constructor
	public AnimalInfoRefactoring(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// method
	public void showAnimalInfo() {
		System.out.println("name >> " + this.name);
		System.out.println("age >> " + this.age + "\n");
	}
	
}
