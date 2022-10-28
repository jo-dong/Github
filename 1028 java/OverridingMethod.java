
/*
 * [Overriding]
 * 	: Method에 적용.
 * <규칙>
 *  : 자식의 접근 권한이 부모의 접근 권한보다 크거나 같아야 한다.
 *  		부모 접근 권한 <= 자식 접근 권한
 */

class Parent {
	
	public void clean() {
		System.out.println("부모님 >> 집 청소");
	}
	
}

class Child extends Parent {
	
	@Override
	public void clean() {
		System.out.println("자식 >> 내 방만 청소");
	}
	
}

public class OverridingMethod {

	public static void main(String[] args) {

		Child child = new Child();
		child.clean();
		
	}

}
