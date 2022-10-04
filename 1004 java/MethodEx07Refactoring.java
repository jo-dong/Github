import java.util.Scanner;

public class MethodEx07Refactoring {

	public static void main(String[] args) {

		/*
		 *  불연속적으로 반복되는 코드를
		 *	Method로 만들어서 사용하는 방법
		 *
		 *	: 반복 코드를 블럭 지정
		 *	Refactor 메뉴 -> Extract Method(Alt + Shift + M)
		 *	Method Name : 원하는 메소드 네임 작성
		 *	public 체크 -> OK
		 *	밑에 있는 아이들까지 한 번에 바뀜
		 */
		
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
		
		int num = 5;
		
		increment(num);		
		
		Scanner input = new Scanner(System.in);
		System.out.println("정수 1개 입력 >> ");
		int userValue = input.nextInt();
		
		increment(userValue);
		
		int var = 10;
		
		increment(var);
		
		input.close();
		
	}

	public static void increment(int num) {
		num++;
		System.out.println(num);
	}

}









