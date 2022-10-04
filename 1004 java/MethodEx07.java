import java.util.Scanner;

public class MethodEx07 {

	public static void main(String[] args) {

		// 불연속적으로 반복되는 코드를
		// Method로 만들어서 사용하는 방법
		// EX)
		
//		int num = 1;
//		
//		System.out.println(num);
//		num++;
//		
//		int var = 10;
//		var = var * 10;
//		System.out.println(var);
//		
//		System.out.println(num);
//		num++;
//		
//		System.out.println(num);
//		num++;
//		
//		System.out.println(num);
//		num++;
		
		// -----------------------------
		// Ctrl + F7 , → Project Explorer
		// Project Explorer에서 Ctrl C , Ctrl V → MethodEx07Refactoring(파일 이름)
		
		int num = 5;
		
		// Method 호출
		increment(num);		// 증가 / 출력			// num++; sysout(num); 한 것과 같은 효과
		
		Scanner input = new Scanner(System.in);
		System.out.println("정수 1개 입력 >> ");
		int userValue = input.nextInt();
		
		// Method 호출
		increment(userValue);	// 증가 / 출력
		
		int var = 10;
		
		// Method 호출
		increment(var);			// 증가 / 출력
		
		input.close();
		
	}	// End main Method
	
	// [Method 정의]
	public static void increment(int num) {
		num++;
		System.out.println(num);
	}

}	// End Class









