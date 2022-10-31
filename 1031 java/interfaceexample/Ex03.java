package interfaceexample;

// interface의 method는 기본 값 => public abstract
interface Method {
	void one();
	
	public abstract void two();
	
	// default void ~ : 일반 Method 생성 가능
//			void defaultMethod() {} 		: Error 
	default void defaultMethod() {
		System.out.println("interface 내 default member method");
	}
	
	// static method
	static void staticMethod() {
		System.out.println("interface 내 static member method");
	}
	
}

// class Sub extends Method {}		// Error : implements 사용
class Sub implements Method {
	@Override
	public void one() {
		System.out.println("Sub class : Overriding Method one()");
	}

	@Override
	public void two() {
		System.out.println("Sub class : Overriding Method two()");
	}
}

public class Ex03 {

	public static void main(String[] args) {

		// 1. interface는 객체 생성 불가능
//		Method m = new Method();	// Error
		
		// 2. polymorphism
		Method m = new Sub();
		m.one();
		m.two();
		m.defaultMethod();
//		m.staticMethod();	 	// Error
		Method.staticMethod();	// interface명으로 접근(static)
		
	}

}
