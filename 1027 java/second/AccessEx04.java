package second;

import first.AccessEx01;

public class AccessEx04 extends AccessEx01 {	// 상속 : 01 -> 부모, 04 -> 자식

	void show() {
//		System.out.println(one);		// private : 상속을 받은 자식이라도 못 씀
//		System.out.println(two);		// default : 같은 package가 아니면 사용할 수 없음
		System.out.println(three);		// protected : 상속 관계라면 접근 허용(package가 달라도 상관 없음)
		System.out.println(four);		// public : 아무나 다 씀
	}
	
}
