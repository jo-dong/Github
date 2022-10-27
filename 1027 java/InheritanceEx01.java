/*
 * [상속; Inheritance]
 * 	: 다른 클래스 내에 의미 정의된 멤버를 사용하는 것.
 * 	: 부모-자식 관계(자식이 부모를 선택, 자식은 부모를 알지만 부모는 자식을 모른다(알 필요가 없음)) 
 * 
 * [객체 생성 순서]
 * 	1. 메모리 할당 : 부모 => 자식
 * 	2. 생성자 호출 : 부모 => 자식
 */

class GrandParent {
	
}

class Parent {
	// 부모 클래스
	int money = 1000000;
	
	void buy(int money) {
		this.money -= money;
		System.out.println("남은 돈 >> " + this.money);
	}
	
}

// class Child extends Parent, GrandParent {	// ERROR : Java는 다중 상속을 허용하지 않는다.
class Child extends Parent {					// 단일 상속만 허용
	// 자식 클래스
	void study() {
		System.out.println("stydying...");
	}
	
	// 부모와 같은 메소드를 만들면 자식 것만 실행됨.
	/*
	 * [Method Overriding]
	 * 	: 상속 관계에서 자식 class가 부모 class의 member method 재정의
	 * 	: 부모 class의 member method에서 선언부는 그대로, body(기능)만 수정
	 *  : 단, 반환형, 메소드명, 매개변수 정보는 그대로(같아야 함)
	 */
	void buy(int money) {
		System.out.println("용돈 : " + money);
	}
	
	/*
	 * [Method Overloading]
	 * 	: 같은 이름의 method 여러 개 정의
	 *  : 단, 매개 변수의 정보가 달라야 함
	 *  : 반환형과 관련 없음
	 */
	void buy() {
		System.out.println("용돈");
	}
	
}

public class InheritanceEx01 {

	public static void main(String[] args) {
		
		Child c = new Child();
		c.buy(10000);
		c.study();
		
		
	}

}
