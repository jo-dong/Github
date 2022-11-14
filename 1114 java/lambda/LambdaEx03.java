package lambda;

class Animal {
	void showInfo() {
		System.out.println("I'm Animal");
	}
}

public class LambdaEx03 {

	public static void main(String[] args) {

		Animal one = new Animal();
		one.showInfo();					// 재사용 가능

		new Animal().showInfo();		// 재사용 불가능
		
	}

}
