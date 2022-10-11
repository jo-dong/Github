import java.util.Scanner;

public class Quiz01I {
	
	public static int factorial(int userValue) {
		if (userValue == 1)
			return 1;
		else
			return userValue * factorial(userValue-1);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userValue = 0;
		
		while(true) {
			System.out.print("1~10 사이의 정수 입력 : ");
			userValue = input.nextInt();
			
			if(userValue < 10)
				break;
		}
		
		System.out.println(userValue + "! : " + factorial(userValue));
		
		input.close();
	}
}
