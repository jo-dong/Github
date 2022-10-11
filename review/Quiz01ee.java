import java.util.Scanner;

public class Quiz01ee {
	
	//팩토리얼 메서드 정의
	static int factorial(int num) {
		int mul = 1;
		for(int i=1; i<=num; i++)	{
			mul *= i;
		}
		return mul;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//사용자 값 입력
		//사용자 값 판별
		int userValue;
		while(true) {
			System.out.print("1 ~ 10 사이의 정수 입력: ");
			userValue = input.nextInt();
			
			if(userValue>=1 && userValue<=10) {
				break;
			}
			else
			continue;
		}
		
		//팩토리얼 메서드 실행 결과 출력
		System.out.printf("%d!: %d", userValue, factorial(userValue));
		input.close();

	}

}
