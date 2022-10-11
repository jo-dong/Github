import java.util.Scanner;

public class Quiz01cc {

	public static void factorial(int i) {
		
		int fact = 1;
		int temp = i;
		int userValue;
		
		for(; i>0; i--) {
			if(i <= 10 && i >=1) {
				fact = fact * i;
			}			
		}
		System.out.println(temp + "! : " + fact);
	}
	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int userValue;
		System.out.print("1~10 사이의 정수 입력 : ");
		userValue = input.nextInt();
		
		while(userValue < 1 || userValue > 10) {
			
			System.out.print("1~10 사이의 정수 입력 : ");
			userValue = input.nextInt();
			
			if(userValue >= 1 && userValue <= 10) {
				factorial(userValue);
			}
		}
	}

}
