// 예외 객체 생성

package exception;

import java.util.Scanner;

class Check extends Exception {
	int num;

	public Check(int num) {
		super("> Error!! 음수 값 입력!");			// getMessage 만드는 법
		this.num = num;
	}
	
}

public class ExceptionEx01 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// 키보드로 입력 => RAM(Buffer; 임시 기억 장치)에서 resource 할당 => resource 해제 해줘야 함
		// : input.close();

		System.out.print("정수를 입력하세요 : ");
		int userValue = input.nextInt();

		input.close();			// throw new Check(uV) : Resource leak: 'input' is not closed at this location
								// 그래서 여기서 닫아줌
		
		// 음수를 입력 받았을 때, 예외 발생
		if (userValue < 0) {
			try {
				// Exception 객체 생성
				throw new Check(userValue); 	// throw : 예외 객체 발생 / throws : 예외 전가
			} catch (Check e) {					// 참조변수 e
//				System.out.println(e);
//				System.out.println(e.getMessage());
				e.printStackTrace();			// 진짜 Error 같이 보임
			}
		}

		System.out.println("입력된 값 >> " + userValue);

	}

}
