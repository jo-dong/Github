/*
 * [Throws] : 예외 전가
 *  - method 선언부에 표현
 */

package exception;

import java.util.Scanner;

public class Ex02 {

	public static void inputData() throws ArithmeticException, Exception {

		System.out.println("=== inputData method ===> start");

		Scanner input = new Scanner(System.in);

		System.out.print("정수 2개 입력 : ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();

		int result1 = n1 / n2;
		int result2 = n1 % n2;
		System.out.println("몫 >> " + result1);
		System.out.println("나머지 >> " + result2);

		System.out.println("=== inputData method ===> finish");

		input.close();

	}

	public static void main(String[] args) {

		System.out.println("[main method] >>> start");
		try {
			inputData();
		} catch(Exception e) {
			System.out.println("e.getMessage() >> " + e.getMessage());
			System.out.println("분모가 0이라 main이 대신 똥 치우는 중...");
			e.printStackTrace(); 		// 기본 Exception Message (잘 안 씀)
										// stack에 있는 애를 가져오다보니 실행창(console)이 엉망진창이 될 수도 있다.
		}
		System.out.println("[main method] >>> finish");

	}

}
