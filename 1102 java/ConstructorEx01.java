
class Parent {
	public Parent() {
		System.out.println("Parent's Constructor");
	}
}

class Child extends Parent {
	String name;
	
	public Child() {
//		super();			// 둘 다 첫 째 줄에 와야하는 애들이라서 같이 명시하지 않는다.
//		this("무명");		
	}
	
	public Child(String name) {
		this.name = name;
	}
}

public class ConstructorEx01 {

	public static void main(String[] args) {

		
		
	}

}
