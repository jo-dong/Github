/*
 *  Method
 *  - 기능, 동작
 *  - 정의 후 호출
 *  
 *  정의 형태
 *  : Return형 Method명(매개변수 1, 매개변수2) {	// 매개변수 : 있어도 되고 없어도 됨, 개수에 제한 없음(소괄호는 꼭 있어야 함)
 *  		명령어;									// Return형 : return 값의 자료형
 *  		명령어;					
 *  		return 값;								// return 값 : 있어도 되고 없어도 됨, 1개
 *  }												// return 값을 생략해도 Method명 왼쪽엔 return명을 반드시 적어야하고, void를 적어준다.
 *  												// ex) return 5;  →  int 사용
 *  
 *  호출 형태
 *  :  Method명 (값1, 값2, ...)		// 값은 매개변수의 수가 같아야 함 
 *  
 */

public class MethodEx01 {

	// 1. Method 정의
	// Method 형태 : 매개변수 X, 리턴값 X
	public static void show() {		// 선언부
		
		System.out.println("show() Method 실행 : 시작");
		System.out.println("show() Method 실행됨");				// (1)
		System.out.println("show() Method 실행 : 종료");
		
	}
	
	public static void main(String[] args) {	// 실행(Run)의 핵심 메소드 : main
		
		System.out.println(">>> main() Method 실행 : 시작");	// (2)
		// 2. Method 호출
		show();		// main에서 show() 메소드를 호출해줘야 실행이 됨
		
		System.out.println(">>> main() Method 실행 : 종료");	// (3)			출력 순서 : 2 - 1 - 3
	}

}
