package staticexample;

class Thing {
	// 멤버 변수(field) : instance field, static(class) field
	private int one;			// instance field
	static int two;				// static field : 얘도 자동 초기화 값 = 0
	
	// 멤버 메소드 : instance method, static(class) method
	public void printOne() {			// instance method
		System.out.println(this.one);
	}
	
	public static void printTwo() {		// static method
//		System.out.println(this.one);	// Error : static method 내에 instance field는 들어올 수 없다.
		System.out.println(Thing.two);
	}
}

public class Ex01 {

	public static void main(String[] args) {

		// static field
		System.out.println("static field >> " + Thing.two);
		
		// static method : Class Name을 통한 접근 => static
		Thing.printTwo();
		
		// object	: 1. memory 할당 2. 생성자 호출
		// Thing thing = new Thing();	: 객체 생성을 하는 데에 비용(cost) 발생
		// static을 사용하여 바로 접근 / 남발하면 안됨
	}

}
