import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("숫자 입력[종료는 0 입력]");
		int userValue = 0;
		int sum = 0;
		
		while(true) {
			System.out.print(">> ");
			userValue = input.nextInt();
			if(userValue != 0)
				sum += userValue;
			else
				break;
		}
		System.out.println("합계 : " + sum);
		input.close();
	}

}
