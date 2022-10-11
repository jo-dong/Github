import java.util.Scanner;

public class Quiz01D {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int userNumber = 1;
		int sum = 1;
		
		while (true) {
			System.out.print("1~10 사이의 정수 입력 : ");
			userNumber = input.nextInt() ;
			
			if (userNumber <=10)
				break;

			while (userNumber != 0) {
				
				sum = sum * userNumber;
				userNumber--;
			}	
		}
		
		System.out.println("누적합 >> " + (sum * userNumber));

	}

}
