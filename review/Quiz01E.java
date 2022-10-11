import java.util.Scanner;

public class Quiz01E {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int result = 1;
		System.out.print("1~10 사이의 정수 입력 : ");
		int userValue = input.nextInt();
		
		while(true) {
			if (userValue < 1 || userValue > 10) {
				System.out.print("1~10 사이의 정수 입력 : ");
				userValue = input.nextInt();
			}
			else {
				for(int i=userValue;i>0;i--) {
					result *= i;
				}
				break;
			}
		}
				
		System.out.println(userValue + "! : " + result);
		
		input.close();
	}

}
