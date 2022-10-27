// ** java code 작성 시 꼭 지켜야 할 순서 **
// 1. package : 현재 파일이 속한 경로, 1개 파일에 2개 이상의 package는 있을 수 없다(단 1개)
package first;
// 2. import

// 3. class

/*
 * [접근 제어자](접근 권한, 접근 제어 지시자)
 * 	: 클래스, 멤버 변수, 메소드, 생성자에 사용 (지역 변수는 사용 불가)
 * ==========================================================================
 * 	-     종류 	   : private	<	default		<=	protected	<	 public
 * --------------------------------------------------------------------------
 * 	- 접근 허용 범위 : 같은 class	  같은 package		   상속			  누구나
 * --------------------------------------------------------------------------
 * 
 */

public class AccessEx01 {
	// 실행을 하려고 쓰는 함수가 아니기 때문에 main 메소드 필요 없음
	// Run 해도 아무 일도 안 일어남
	
	// Member variables	= Instance variables
	private int one = 1;
	int two = 2;	// default는 작성하는 것이 아님, 아무것도 쓰지 않는 것이 default
	protected int three = 3;
	public int four = 4;
	
	// Member Method = Instance Method
	void show() {
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
	}

}
