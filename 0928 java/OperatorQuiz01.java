import java.util.Scanner;

public class OperatorQuiz01 {

	public static void main(String[] args) {

		// Q1) 사용자에게 정수 2개를 입력 받은 후 큰 값 출력
		// 	   삼항 연산자 이용
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("서로 다른 정수 2개 입력");
		int a = input.nextInt();
		int b = input.nextInt();
		int big = (a > b) ? a : b;
		System.out.println("큰 값 : " + big);
		
	}

}
