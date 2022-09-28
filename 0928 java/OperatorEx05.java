// #5

/*
 * [삼항 연산자(조건 연산자)]
 * 조건 ? A : B;
 * 조건이 true이면 A 출력, false이면 B 출력
 */

public class OperatorEx05 {

	public static void main(String[] args) {

		// [삼항 연산자 (조건 연산자)]
		int num = 5;
		
		// [유형 1]
		String result = (num > 5) ? "Big" : "Small or Equal";  // 조건문에 () 치는게 국룰
		System.out.println("result >> " + result);
		
		// [유형 2]
		// (num > 4) ? System.out.println("크다") : System.out.println("작거나 같다");
		//			Error : Java 문법 상 좌항(변수) = 우항; 이 완성되어야 함
		
	}

}
