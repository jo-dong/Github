
/*
 * final의 의미 : 금지
 * 	- final class	 : Inheritance(상속) 금지, sub class를 두지 않음.
 * 	- final method	 : Method Overriding 금지, 부모 메소드만 따라 써야함.
 * 	- final variable : 초기화한 값 고정, 값 변경 금지
 * 
 */

//final class ParentFour { 	// final class A : class A는 자식 class를 두지 않겠다. 
class ParentFour {	
	String address;
	
	public ParentFour() {}	// 기본적으로 만들어 주는게 좋음
		
	public ParentFour(String address) {
		this.address = address;
	}
	
//	final public(public final) void clean () {	// Overriding 금지
	public void clean() {
		System.out.println("집 청소");
	}
	
	public void showInfo() {
		System.out.println("집 주소 : " + this.address);
	}
}

class ChildFour extends ParentFour {
	
	public ChildFour(String address) {
		super(address);
	}
	
	@Override	// annotation : 1. 아래 코드가 쓰임에 맞는지 컴파일러가 문법 검사를 해줌
				//				2. 개발자에게 시각적으로 알려줌
	public void clean() {
		System.out.println("자식 >> 내 방만 청소");
	}
	
}

public class InheritanceEx04 {

	public static void main(String[] args) {

		ChildFour c4 = new ChildFour("서울 구로구");
		c4.showInfo();		// 상속을 해서 마치 childfour의 메소드인 마냥 사용 가능
		c4.clean();
	}

}
