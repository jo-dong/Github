package first;

public class AccessEx02 {
	// 다른 package에 있는 class의 Member를 사용하고 싶다?
	// 두 가지 방법 : 1. 상속 2.포함
	
	// 멤버 변수
	AccessEx01 ac = new AccessEx01();
	
	void show() {
//		System.out.println(ac.one);		// private int one = 1; : 다른 클래스에서 사용 불가
		System.out.println(ac.two);		// (default) int two = 2; : 같은 package 내에서 사용 가능
		System.out.println(ac.three);	// protected int three = 3;
		System.out.println(ac.four);	// public int four = 4;
	}
	
	
	
}
