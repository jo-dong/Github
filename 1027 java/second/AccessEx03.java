package second;		// 현재 위치

import first.AccessEx01;	// 사용하고 싶은 다른 package의 위치

public class AccessEx03 {
	// 멤버 변수
	AccessEx01 ac = new AccessEx01();	// 다른 패키지에 있는 파일이라 ERROR
	
	// 멤버 메소드
	void show() {
//		System.out.println(ac.one);		// Error : ac.one -> private (같은 class 내 접근 허용)
//		System.out.println(ac.two);		// Error : ac.two -> default (같은 package 내 접근 허용)
//		System.out.println(ac.three);	// Error : ac.three -> protected (상속 관계일 때만 접근 허용)
		System.out.println(ac.four);	// ac.four -> public
		
		
	}
	
}
