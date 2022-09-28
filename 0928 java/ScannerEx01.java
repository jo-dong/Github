// #6

import java.util.Scanner;		// Scanner Class 호출 : Scanner Class의 경로를 class 밖(위)에 써주어야 함

public class ScannerEx01 {

	public static void main(String[] args) {

		// 사용자로부터 값 입력 받기
		
		// 1. Scanner 객체 생성
		Scanner input = new Scanner(System.in);		// 변수 input에는 객체의 주소 정보가 저장
		
		// 정수 2개 입력하기 [Type 1]
		
		// 2.1 정수 1개 입력 받기 - nextInt()
//		System.out.println("정수 1개를 입력하세요...");
//		int num = input.nextInt();
//		System.out.println("입력 값 >> " + num);
//		 
////	  →	console 창에 임의의 정수 1개를 입력하면 num에 입력한 정수가 저장되며 출력된다.
//		
//		input.nextLine();				// 2.1과 2.2를 순차적으로 실행하기 위해 삽입
//		
//		// 2.2 정수 1개 입력 더 받기
//		System.out.println("정수 1개 더 입력");
//		int num1 = input.nextInt();
//		System.out.println("입력 값 : " + num1);
		
//		--------------------------------------------------------------------------------
		
		// [Type 2]
		System.out.println("정수 2개 입력");
		int num = input.nextInt();
		int numTwo = input.nextInt();
		System.out.println("입력된 정수 >> " + num + ", " + numTwo);
		
		// 1) 입력 시에 3 (Enter) 5			2) 입력 시에 3 (Tab) 5
		
	}

}
