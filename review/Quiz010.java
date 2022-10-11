import java.util.Scanner;

public class Quiz010 {

	public static int factorial(int num) {	
		
		int result = 1;	
		
		for (int i=1; i<=num; i++) {
			result *= i;	// result = result * i
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userValue=0;

		while(true) {
			
		System.out.print("1~10 사이의 정수 입력 : ");
		userValue = input.nextInt();
		
			if(userValue>=0 && userValue<=10) {
				break;
			} else {
				factorial(userValue);
			}
	
		}
		System.out.println(userValue+"! : "+factorial(userValue));
		input.close();
	}
}
		

