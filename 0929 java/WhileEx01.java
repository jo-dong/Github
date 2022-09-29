
/*
 * [While문]
 * 
 * while (조건식) {		// 조건이 true일 동안 반복
 * 		명령문;			// false가 되는 순간 while문 탈출
 * 		명령문;
 * }
 * 	
 */

public class WhileEx01 {

	public static void main(String[] args) {

		int num = 1;				// 초기값
		
		while(num < 4) {			// 조건식; 
									// 반복문 실행 전 반드시 num이라는 변수가 선언되어있어야함
			System.out.println(num);
			num++;					// 증감식
		}
		// 반복문 실행 후 num = 4
		
		System.out.println("프로그램 종료");
		
		
		
	}

}
