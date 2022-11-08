package inner;

// Class file명
// OuterClass.class		OuterClass$InnerClass.class

class Outer {
	
	class Inner {
		// instance field
		int num;
		
		// constructor
		public Inner(int num) {
			this.num = num;
			System.out.println("Inner class의 생성자 실행 완료!");
		}
		
		// instance method
		void showNum() {
			System.out.println("Inner class의 instance field : num >> " + this.num);
		}
	}
	
}

public class InstanceInnerClassEx01 {

	public static void main(String[] args) {

		// 1-1. Outer 객체 생성 (먼저 해줘야 Inner 객체가 생성됨)
		Outer out = new Outer();
//		
		// 1-2. Inner 객체 생성
		Outer.Inner in = out.new Inner(0);	// 외부 클래스의 참조변수를 통해 객체 생성
		in.showNum();
		
		// 2. Inner 객체 생성 - 한 줄로
		Outer.Inner in2 = new Outer().new Inner(0);
		in2.showNum();
		
	}

}
