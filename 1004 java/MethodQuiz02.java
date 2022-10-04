		
		// [Method 정의]
		// - 기능 : 정수 1개를 받아서 제곱값 출력
		// 출력형태 : 2의 제곱은 4입니다.
		// - Method명 : square, 매개변수 : 1개, 리턴값 : 없음

public class MethodQuiz02 {

	public static void square(int n1) {
		
		System.out.println(n1 + "의 제곱은 " + (n1 * n1) + "입니다.");
		
	}
	
	// main Method
	public static void main(String[] args) {

		square(2);
		square(3);
		square(4);		
		
	}

}
