

import java.util.Scanner;

public class Quiz01aa {

	public static int factorial(int num) {
		int factorial = 1;
		for (int i = 1; i <= num; i++)
			factorial = factorial * i;
		return factorial;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int userValue = 0;
		while (true) {
			if (userValue <= 0 || userValue > 11) {
				System.out.print("1~10 사이의 정수 입력 : ");
				userValue = input.nextInt();
			} else
				break;
		}
		System.out.println(userValue + "! : " + factorial(userValue));
			
		input.close();
	}

}
