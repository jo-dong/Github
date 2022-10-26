
class Car {
	
	int door;
	String color;
	
	// 생성자 오버로딩
	public Car() {
		this(4, "black");
	}
	
	public Car(int door) {
		this(door, "black");
	}
	
	public Car(String color) {
		this(4, color);
	}
	
	public Car(int door, String color) {
		this.door = door;
		this.color = color;
	}
	
	// 멤버 메소드
	public void carInfo() {
		System.out.println("문 개수 : " + door + "\n색 : " + color);
	}
	
}

public class ConstructorQuiz {

	public static void main(String[] args) {

		Car c1 = new Car();
		c1.carInfo();
		
		Car c2 = new Car(2);
		c2.carInfo();
		
		Car c3 = new Car("white");
		c3.carInfo();
		
		Car c4 = new Car(6, "grey");
		c4.carInfo();
		
	}

}
