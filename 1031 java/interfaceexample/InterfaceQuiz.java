package interfaceexample;

interface Vehicle {
//	int carNumber = 8586 ;
//	int yachtNumber = 679111;
	public abstract void printNumber();	// abstract method
}

class Car implements Vehicle {
	int carNumber;
	
	public Car() {
	}
	
	public Car(int carNumber) {
		this.carNumber = carNumber;
	}
	
	@Override
	public void printNumber() {
		System.out.println("자동차 등록번호 : " + this.carNumber);
	};
	
	public void drive() {
		System.out.println("자동차가 고속도로를 달립니다.\n");
	}
}

class Yacht implements Vehicle {
	int yachtNumber;
	
	public Yacht() {

	}
	
	public Yacht(int yachtNumber) {
		this.yachtNumber = yachtNumber;
	}
	
	@Override
	public void printNumber() {
		System.out.println("요트 등록번호 : " + this.yachtNumber);
	};
	
	public void sail() {
		System.out.println("요트가 한강 위를 떠다닙니다.");
	}
}

public class InterfaceQuiz {

	public static void main(String[] args) {

		Vehicle[] myVehicle = new Vehicle[2];
		myVehicle[0] = new Car(8586);
		myVehicle[1] = new Yacht(679111);
		
		// 1. 반복문 : method drive(), sail() 호출
		// [실행 결과]
		// 자동차 등록번호 : 8586			// abstract method로 구현; printNumber()
		// 자동차가 고속도로를 달립니다.
		
		// 요트 등록번호 : 679111			// abstract method로 구현
		// 요트가 한강 위를 떠다닙니다.
		
		Car car = new Car();
		Yacht yacht = new Yacht();
		
		for(int i=0; i<myVehicle.length; i++) {
			myVehicle[i].printNumber();
			if(i==0) 
				car.drive();
			else
				yacht.sail();
		}

	}

}
