package inner;

/* ===================================================
 * Anonymous Class - 선언과 동작에 따라 3가지 유형으로 나뉨
 * 	1) 클래스 확장
 * 	2) 인터페이스 구현
 *  3) 인수
 *  	=> 궁극적인 목표 : 메소드 재정의(Overriding)
 =================================================== */

class Super {
	// constructor
	public Super() {
		System.out.println("Run : [Super class] constructor");
	}
	
	// instance method
	public void print() {
		System.out.println("Run : [Super class] print()");
	}
}

class Sub extends Super {
	
	// constructor
	public Sub() {
		System.out.println("Run : [Sub class] constructor");
	}
	
	// instance method
	public void show() {
		System.out.println("Run : [Sub class] show()");
	}
}

public class AnonymousInnerClassEx01 {

	public static void main(String[] args) {

		// polymorphism
//		Super s = new Sub();
		
		// Anonymous class ======================================================
		Super anonymous = new Super() { 				// 상속이 필요 없음
			// constructor 불가능 - class 명이 없기 때문
			// instance method - 외부에서 접근 절대 불가능 / 영역 내에서만 사용 가능
			// Super의 것을 Overriding 하면 사용 가능
			public void say() {
				System.out.println("I'm Instance method in Anonymous Class");
			}
			
			@Override
			public void print() {
				System.out.println("Override in Anonymous Class");
			}
			
			@Override
			public String toString() {
				return "I'm Anonymous Class";
			}
			
		};		// 세미콜론 빠지면 안됩니당
		// ======================================================================
		
		System.out.println(anonymous);		// anonymous class의 주소 출력
		anonymous.print();
		
	}

}
