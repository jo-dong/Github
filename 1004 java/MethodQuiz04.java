
		// [Method 정의]
		// - 기능 : 정수 1개를 입력 받아서 팩토리얼 출력
		// - Method Name : factorial, 매개변수 : 1개, 리턴값 : 없음

public class MethodQuiz04 {

	public static void factorial(int i) {
		
		int fac = 1;
		for(; i>0 ; i--) {
			fac = i * fac;			
		}
		System.out.println("5! = " + fac);
	}	
	
	public static void main(String[] args) {

		factorial(5);
		
	}

}
