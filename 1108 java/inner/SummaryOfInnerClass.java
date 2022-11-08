package inner;

/*
 * [Inner Class]
 * 	- class 내부에 정의된 class
 * 	- Member Class
 * 		cf) class 내 member : field, method, class
 *  - 외부 클래스와 내부 클래스는 서로 긴밀한 관계일 때 정의한다.
 * 
 *  - Inner Class의 장점
 *  	1) Inner Class는 Outer Class의 멤버 일부에 접근 가능(모든 멤버에 접근 가능한 것은 아님)
 *  	2) Code의 캡슐화 증가 (캡슐화 : 실제 구현 내용 일부를 내부에 감추어 은닉)
 *  	3) 외부에서 내부 클래스에 접근할 수 없으므로, 코드의 복잡성을 줄일 수 있음
 * 	
 * - Inner Class 종류
 * 		1) instance inner class
 * 			: non-static inner class(비정적 내부 클래스) 라고도 함
 * 			: static method는 사용할 수 없음
 * 
 * 		2) static inner class
 * 			: static method에서 사용할 목적
 * 
 * 		3) local inner class
 * 			: method 또는 constructor 내 정의된 class
 * 			: 해당 영역 내에서만 사용 가능한 클래스
 * 
 * 		4) anonymous class
 * 			: 익명 클래스(일회용 클래스); 잠깐 쓸 것이니 정의하지 않겠다
 * 			: 클래스 정의와 동시에 객체 생성 => 하나의 객체만 생성 가능
 * 			: 생성자를 정의할 수 없다. => 이름이 없어서
 * 			: Overriding(재정의)을 하기 위한 목적으로 생성
 *  
 */

class OuterClass {
	//field
	private int one;
	public int two;
	protected int three;
	int four;
	
	// member class : protected(상속 관계 허용)를 붙여 쓰진 않는다.
	// OuterClass와의 관련성 있음을 어필.
	private class InnerClass {
		
		
	}
	
}

public class SummaryOfInnerClass {

}
