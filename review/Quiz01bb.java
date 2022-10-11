import java.util.Scanner;

public class Quiz01bb {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("1~10 사이의 정수 입력 : ");
		int userValue = input.nextInt();

		if (userValue >= 1 && userValue <= 10) {
			int factorial = 1;

			for (int i = 1; i <= userValue; i++) {
				factorial *= i;
			}

			System.out.println(userValue + "! = " + factorial);

		} else if (userValue < 1 || userValue > 10) {

			while (userValue < 1 || userValue > 10) {
				System.out.print("1~10 사이의 정수 입력 : ");
				userValue = input.nextInt();
			}
			
			int factorial = 1;
			for (int i = 1; i <= userValue; i++) {
				factorial *= i;
			}
			
			System.out.println(userValue + "! = " + factorial);
			

		}

		input.close();
	}

}
