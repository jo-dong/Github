package inner;

class OuterFive {
	
	// instance method
	public void instanceMethod() {
		InnerInstance in = new InnerInstance();
		InnerStatic ins = new InnerStatic();
	}
	
	// static method
	public static void staticMethod() {
//		InnerInstance in = new InnerInstance();		// instance inner class이기 때문에 static method에서 사용 불가
		InnerStatic ins = new InnerStatic();		// 가능
	}
	
	// instance inner class
	class InnerInstance {}
	
	// static inner class - Outer class의 static method에서 사용 가능
	static class InnerStatic {}
	
}


public class StaticInnerClassEx02 {

	public static void main(String[] args) {

	}

}
