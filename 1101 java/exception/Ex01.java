/*
 * [예외 처리]
 * 	- try ~ catch ~ (finally) ==> finally는 필수 아님, try ~ catch는 필수
 *  - throws : 예외 전가 => 호출한 method로 전가
 *  
 *  [Syntax]
 *  try {
 *   	예외 발생 가능한 코드
 *  } 
 *  catch(클래스명 참조변수) {				// 예외가 발생하지 않으면 catch 실행 안함
 *  	예외가 발생했을 때, 처리할 코드
 *  } 
 *  			.
 *  			.						// catch는 여러 개가 올 수 있다. (위에서부터 아래로 실행)
 *  			.
 *  catch(클래스명 참조변수) {
 *  	
 *  } 
 *  finally {
 *  	예외 발생 여부와 상관 없이, 무조건 마지막에 실행되는 영역
 *  }
 *  
 *  [예외 종류]
 *  	발생 시기에 따라
 *  	컴파일(compile)			실행(runtime)
 *  	syntax error			OS, H/W, Network에 따라 종류가 굉장히 많다.
 */

package exception;

import java.util.Scanner;

public class Ex01 {
	
	public static void inputData() {
		
		System.out.println("=== inputData method ===> start");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수 2개 입력 : ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int result1 = 0;
		int result2 = 0;
		// 방법 1 -------------------------------------
		try {
			// 예외 발생 가능한 구간
			result1 = n1/n2;
			result2 = n1%n2;
			System.out.println("몫 >> " + result1);
			System.out.println("나머지 >> " + result2);
		}catch(ArithmeticException e) {
			// 예외 발생했을 때, 실행할 코드
			System.out.println("분모가 0으로 계산 불능!");
			System.out.println("e >> " + e); 	// e >> java.lang.ArithmeticException: / by zero
		}catch(Exception e) {	// 부모 예외를 아래쪽에 둬야함!
			System.out.println("예외 발생");
		}finally {
			// 예외 발생과 상관 없이, 무조건 마지막에 실행되는 영역
			System.out.println("===finally 영역===");
		}
		// 방법 2 -------------------------------------
//		try {
//			// 예외 발생 가능한 구간
//			result1 = n1/n2;
//			result2 = n1%n2;
//		}catch(ArithmeticException e) {
//			// 예외 발생했을 때, 실행할 코드
//			System.out.println("분모가 0으로 계산 불능!");
//		}finally {
//			// 예외 발생과 상관 없이, 무조건 마지막에 실행되는 영역
//			System.out.println("몫 >> " + result1);			// 얘는 여기 있으면 안됨 : 예외가 발생 되었을 때
//			System.out.println("나머지 >> " + result2);		// 또 계산을 해서 또 예외가 발생함
//		}
		// ===================================
		
		// n1 = 5, n2 = 0 입력 시 불능(분모가 0)
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		
		System.out.println("=== inputData method ===> finish");
		
		input.close();
		
	}

	public static void main(String[] args) {
		// EX)
//		int[] arr = {2, 4, 6};
//		
//		for(int i=0; i<4; i++)
//			System.out.println(arr[i]);
		// output : Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
		// 범주 내의 Error(Exception; 예외 상황)를 미리 class로 만들어 놓음 
		// => 사용자(개발자)에게 알림(코드 수정 힌트)을 제공
		// -------------------------------------------------------------------------------------
		
		System.out.println("[main method] >>> start");
		inputData();
		System.out.println("[main method] >>> finish");
		
	}

}
