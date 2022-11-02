package book;

public class AnimalInfo {

	private String name;
	private int age;
	
	// constructor
	public AnimalInfo(String animalName, int animalAge) {
		this.name = animalName;
		this.age = animalAge;
	}
	// method
	public void showAnimalInfo() {
		System.out.println("name >> " + this.name);
		System.out.println("age >> " + this.age + "\n");
	}
	
}
