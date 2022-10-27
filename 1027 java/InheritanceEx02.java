
/*
 * 부모 클래스 = parent class = super class = 기반 클래스 = 상위 클래스
 * 자식 클래스 = child class = sub class = 파생 클래스 = 하위 클래스
 */

class ParentTwo {	
	String lastName;
	
	// 생성자 : 무조건 부모가 먼저 실행
	public ParentTwo(String lastName) {
		this.lastName = lastName;
	}
	
	public ParentTwo() {
		
	}
}

class ChildTwo extends ParentTwo {
	
//	// 생성자
//	public ChildTwo(String lastName) {
//		// 자식 생성자를 먼저 찾아오지만
//		// 부모의 생성자 호출을 제일 먼저 실행
//		super();	// 무조건 첫째 줄
//		// 부모 생성자 호출 코드(지금은 적어놨지만 원래 생략되어있음), 없어도 자동으로 부모 생성자 코드를 호출한다.
//		super.lastName = lastName;
//		// 부모의 멤버 변수를 사용 : super.멤버변수명
//		System.out.println("자식의 생성자 실행");
//	}
	
	public ChildTwo() {	// 이걸 만드는 순간 부모 class에도 기본 생성자를 만들어 주어야 한다.
		
	}
	
	// 부모의 생성자를 통해, 멤버 lastName에 값 설정
	public ChildTwo(String lastName) {
		super(lastName);
	}
	
	public void showInfo() {
		System.out.println("저는 " + super.lastName + "씨 입니다.");
	}
}

public class InheritanceEx02 {

	public static void main(String[] args) {

		ChildTwo c2 = new ChildTwo("홍");
		c2.showInfo();
		
		ChildTwo c3 = new ChildTwo();
		c3.showInfo();
		
	}

}
