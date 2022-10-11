import java.util.Scanner;

public class Quiz011 {
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("정수 1~10사이 입력 >>");
		int uservalue = input.nextInt();
		
		while(true) {
		if (uservalue>0 && uservalue<11) {
			System.out.println(uservalue+"! : "+factorial(uservalue));
			break;
		}
			System.out.print("정수 1~10사이 입력 >>");
			uservalue = input.nextInt();
		}  
	

		
	}
	public static int factorial(int uservalue) {
		
		if(uservalue == 1)
			return 1;
		else
			return uservalue * factorial(uservalue -1);
	}
	
}
