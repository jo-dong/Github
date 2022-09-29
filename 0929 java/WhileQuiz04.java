import java.util.Scanner;

public class WhileQuiz04 {

	public static void main(String[] args) {

		/*
		 * 1 ~ 10 사이의 정수 1개를 입력 받은 후
		 * 랜덤값에서 사용자가 입력한 정수 찾기!
		 * 반복문 실행 횟수 출력
		 */
		
		Scanner input = new Scanner(System.in);
		
		int idx = 0; int ranNum = 0;		
		System.out.print("1 ~ 10 사이의 정수 1개 입력 >> ");
		int inputNum = input.nextInt();
		
		while(true) {
			idx++;
			ranNum = (int)(Math.random() * 10) + 1;
			System.out.print(ranNum + " ");
			if (inputNum == ranNum) {
				break;
			}
		}
		
		System.out.println("\n" + idx + "회 실행해서 찾았다!");
		
	}

}
