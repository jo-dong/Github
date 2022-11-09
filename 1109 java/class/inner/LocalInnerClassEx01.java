package inner;

class OuterSix {
	
	/*
	 * [Local Inner Class] ===========================================================================
	 *  : method 내 정의된 class
	 *  : 접근 권한 사용 불가 => 해당 method가 호출이 되어야 접근 가능하기 때문에 자체 접근 권한의 의미가 없다.
	 * 	: static도 불가능 (static class)
	 * ===============================================================================================
	 */
	
	public void show() {
		
		// Class in method ★ ==================== ★
		// show() method가 호출이 되어야 Inner가 생성 / show() method가 끝나면 다시 소멸
		class Inner {					// 접근 권한은 only Default
			// instance field
			int num = 10;
			
			// static field
//			static int user = 100;		// 나만 안됨 (원래 안되는게 맞음, 근데 버전에 따라 허용함)
			
			// constructor
			public Inner() {
				System.out.println("Run : Local Class constructor");
			}
			
			// instance method
			public void printNum() {
				System.out.println("field : num >> " + this.num);
			}
			
		} // End Inner class
		// ★ ==================================== ★
		
		// method 내에서 객체 생성
		Inner in = new Inner();
		in.printNum();
//		Inner.user = 500;
//		System.out.println("static field : user >> " + Inner.user);
		
	} // End show() Method
	
}

public class LocalInnerClassEx01 {

	public static void main(String[] args) {

		OuterSix out = new OuterSix();
		out.show();
		
	}

}
