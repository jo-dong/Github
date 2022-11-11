package lambda;

/*
 * [Lambda Expression]
 *  - Anonymous class의 코드를 간결하게 사용하기 위해
 *  - Interface에 method가 한 개 밖에 없을 때
 *    Overring method(Anonymous class)를 간결하게 표현
 *  
 * 	- Java 8 버전부터 함수형 프로그래밍 지원
 * 	- 익명 함수(anonymous function) 
 * 
 *  [Syntax]
 *      ↓ 괄호 생략 가능 (parameter 1개일 때)
 *  1)	(parameter) -> expression; (return 값)
 *  
 *  2)	(parameter1, parameter2) -> {
 *  		code;
 *  		code;
 *  		return 값;		// return 꼭 써줘야함
 *  	};					// semi colon 있어야 함
 *  
 *  [활용]
 *   1. 참조 변수에 저장하여 사용 가능
 *   2. return
 *   3. 인수
 */

interface Happy {
	int sum(int x, int y);
}

public class LambdaEx01 {

	public static void main(String[] args) {

		// anonymous class
		Happy happy = new Happy() {
			@Override
			public int sum(int x, int y) {
				return x + y;
			}
		};
		
		happy.sum(2, 5);
		
		// lambda 표현식
// interface | 참조변수 | Parameter	  | return 값
		Happy happy2 = (int x, int y) -> x + y;
		Happy happy3 = (x, y) -> x + y;		// type도 생략이 가능
//		우변((int x, int y) -> x + y;) : 람다식 이라고 함
		
		happy2.sum(2, 5);
		happy3.sum(2, 5);
		
	}

}
