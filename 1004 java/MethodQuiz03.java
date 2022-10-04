
		// [Method 정의]
		// - 기능 : 정수 2개를 받아서 몫 출력
		// 출력형태 : (분모가 0이 아닐 경우) 나눗셈 결과 >> 2
		// 			  (분모가 0일 경우) 분모가 0으로 계산 불능
		// - Method명 : divide, 매개변수 : 2개, 리턴값 : 없음

public class MethodQuiz03 {

	public static void divide(int n1, int n2) {
		
		if (n2 != 0) {
			System.out.println("나눗셈 결과 >> " + (n1 / n2));
		}
		else {
			System.out.println("분모가 0으로 계산 불능");
		}
	}
	
	// main Method
	public static void main(String[] args) {

		divide(5, 3);
		divide(4, 0);
		divide(6, 2);
		
	}

}
