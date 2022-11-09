package inner;

class OuterFour {
	
	/*
	 * [Static Inner Class] - ====================================================
	 *  : 외부에서 Outer class의 객체 생성 없이 Inner Class에 접근이 가능
	 *  : Instance와 Static의 모든 field 선언과 method 정의가 가능
	 *  : Outer Class의 Static method는 static inner class 사용 가능
	 * ===========================================================================
	 */
	
	static class Inner {		// OuterFour class가 Load될 때 Static 영역에 할당
		// instance field
		int num = 5;			// Inner Class(즉, Type)는 이미 할당되었지만 instance field인 num은 생성되지 않는다.
		
		// static field
		static int user = 10;
		
		// constructor
		public Inner() {
			System.out.println("Inner class 생성자 실행");
		}
		
		// instance method
		public void show() {	// show() method 역시 Inner class의 객체가 생성되기 전에는 생성되지 않는다.
			System.out.println("instance field : num >> " + this.num);
			System.out.println("static field : user >> " + Inner.user);
		}
		
		// static method : static member만 사용 가능
		public static void showStatic() {
//			System.out.println("instance field : num >> " + this.num);
			System.out.println("static field : user >> " + Inner.user);
		}
	}
}

public class StaticInnerClassEx01 {

	public static void main(String[] args) {

		
		System.out.println("<< 객체 생성 전 >>");
		// showStatic() method 호출
//		in.showStatic();		// Error는 아니지만 static method는 클래스명으로 접근하는 것이 바람직하다.
		OuterFour.Inner.user = 500;
		OuterFour.Inner.showStatic();
		
		System.out.println("\n<< 객체 생성 후 >>");
		// Static Inner class의 객체 생성
//		OuterFour.Inner in = new OuterFour().new Inner();	// Ex01에서 했던 방식
		OuterFour.Inner in = new OuterFour.Inner();			// static이기 때문에 클래스명을 통해 접근하면 된다
		// show() method 호출
		in.show();
	}

}
