
		// [Method 정의 후 호출]
		// - 기능 : 인수로 양의 정수 2개를 받아,
		//			(정수 사이의) 누적합 계산 후 출력
		// - Method명 : add, 매개변수 : 2개, 리턴값 : 없음

public class MethodQuiz01 {

	public static void add(int n1, int n2) {
		int sum1 = 0, sum2 = 0;
		
		if (n1 < n2) {
			for (;n1 <= n2; n1++) {
				sum1 += n1;
			}
			System.out.println("n1과 n2 사이의 누적합 = " + sum1);
		}
		else {
			for (;n2 <= n1; n2++) {
				sum2 += n2;
			}
			System.out.println("n1과 n2 사이의 누적합 = " + sum2);
		}
		
	}
	
	// main Method
	public static void main(String[] args) {

		add(1, 10);
		add(10, 1);
		
	}

}
