
class Animal {
	
	String name;
	
	void showName() {
		System.out.println("제 이름은 " + name + "입니다.");
	}
	
}

public class InstanceQuiz01 {

	public static void main(String[] args) {

		Animal dog = new Animal();
		dog.name = "해피";
		dog.showName();
		
		Animal cat = new Animal();
		cat.name = "나비";
		cat.showName();
		
	}

}
