package inner;

class OuterThree {
	// instance field
	int one = 100;
	
	// static field
	static int two = 200;
	
	// instance method
	public void show() {
		System.out.println(one);
		System.out.println(two);
		
		// Inner Class 객체 생성 - 가능
		Inner in = new Inner();
	}
	
	// static method : static member만 사용 가능
	public static void showStatic() {
//		System.out.println(one);
		System.out.println(two);
		
		// Inner Class 객체 생성 - 불가능(Error) === ★
//		Inner in = new Inner();
	}
	
	// Instance Inner Class
	class Inner {
		
		// inner class의 method는 outer class의 모든 member 사용 가능
		public void showData() {
			System.out.println(one);
			System.out.println(two);
			show();
			showStatic();
		}
		
	}
	
	// OuterThree Class에서 Inner Class 객체 생성 - 가능
	Inner in = new Inner();
	
}

public class InstanceInnerClassEx03 {

	public static void main(String[] args) {

	}

}
