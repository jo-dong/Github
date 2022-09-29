import java.util.Scanner;

public class WhileQuiz05 {

	public static void main(String[] args) {

		/*
		 * [문제]
		 * 사용자에게 정수 1개를 입력 받아 누적합 구하시오.
		 * 실행하면, "정수를 입력하시오(종료 -1) >> " 문자열 출력
		 * 
		 * 사용자가 -1을 입력하면, 정수 입력을 끝내고,
		 * 입력된 정수의 총 합을 출력하시오.
		 */
		
		Scanner input = new Scanner(System.in);
		
		int sum = 0;	
		System.out.print("정수를 입력하시오(종료 : -1) >> " );
		int userNum = input.nextInt();
		
		while (userNum != -1) {
			sum += userNum;
			System.out.print("정수를 입력하시오(종료 : -1) >> " );
			userNum = input.nextInt();
			if (userNum == -1) {
				break;
			}
		}
		System.out.println("총합 >> " + sum);
		
	}

}
