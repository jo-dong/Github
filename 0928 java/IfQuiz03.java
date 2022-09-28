import java.util.Scanner;

public class IfQuiz03 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.print("정수 2개 입력 : ");
		
		int a = input.nextInt();
		int b = input.nextInt();
		
		if (a > b) {
			System.out.print("큰 값 : " + a + ", 작은 값 : " + b);
		}
		else { 
			System.out.print("큰 값 : " + b + ", 작은 값 : " + a);
		}
							
	}

}
