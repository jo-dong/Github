package lambda;

/*
 * [Lambda Expression]
 *  - Anonymous class의 코드를 간결하게 사용하기 위해
 *  - Interface에 abstract method가 한 개 밖에 없을 때 - (Functional Interface의 개념)
 *    Overring method(Anonymous class)를 간결하게 표현
 *  - 사실상 객체로 관리
 *  
 * 	- Java 8(JDK 1.8) 버전부터 함수형 프로그래밍 지원을 위해 Lambda, Stream 도입
 * 	- 익명 함수(anonymous function) -> 메서드명 없음  	// method : 클래스 내에 멤버로 선언된 함수
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
 *  [특징]
 *   - 메서드명과 반환형 생략, return 키워드 대신 식(expression) 사용
 *   - 람다식 내에 선언된 지역 변수 == 무조건 final
 *   
 *  [장점]
 *   - 간결한 코드
 *   - 식에 개발자 의도가 명확히 드러나, 가독성 높아짐
 *   - method 정의 없이 한 번에 처리가 가능하므로 생산성 높아짐
 *   
 *  [단점]
 *   - 익명 함수이므로(일회용) 재사용 불가능
 *   - Debugging 어려움(문법 검사 어려움)
 *   - 재귀 부적합
 *  
 *  [활용]
 *   1. 참조 변수에 저장하여 사용 가능
 *   2. return
 *   3. 인수
 */

// 1. interface 생성
@FunctionalInterface	// 'abstract' method가 반드시 1개만 와야한다.
interface Mood {
	// abstract Method
	String howAreYouFeeling(String feel);
//	int sum(int n1, int n2); : 얘는 올 수 없음
	
	// instance method	: 얘는 와도 ㄱㅊ
	default void show() {}
	
	// static method	: 얘도 ㄱㅊ
	static void print() {}
}

// 2. Overriding 위해 Class 생성
class Person implements Mood {
	@Override
	public String howAreYouFeeling(String feel) {
		return "오늘 기분 : " + feel;			// + : concat(" ") 자동 실행
	}
}

public class LambdaEx02 {

	public static void main(String[] args) {

		// 3. 객체 생성 - 다형성
		Mood instance = new Person();
		String one = instance.howAreYouFeeling("똑같다");
		
		System.out.println(one);
		
		// 4-1. Anonymous Class - 참조변수 이용
		Mood moodAnonymous = new Mood() {
			@Override
			public String howAreYouFeeling(String feel) {
				return "[reference] I feel like " + feel;
			}
		};
		
		System.out.println(moodAnonymous.howAreYouFeeling("good"));
		
		// 4-2. Anonymous Class - 바로 출력
		System.out.println(new Mood() {
			@Override
			public String howAreYouFeeling(String feel) {
				return "[Direct] I feel like " + feel;
			}
		}.howAreYouFeeling("good"));
		
		// << interface의 method를 Lambda식으로 표현 >> =============================
		// ------------------------ [방법 1] 참조 변수에 저장 ------------------------
		// 5-1. Method명, return type 생략 / parameter 정보(Type, name)만 입력
		Mood lambdaOne = (String arg) -> "[1.1] I feel like " + arg;
		
		String str = lambdaOne.howAreYouFeeling("sad");
		
		System.out.println(str);
			
		// 5-2. Method명, return type, parameter 정보(Type) 생략 / name만 입력
		Mood lambdaTwo = arg -> "[1.2] I feel like " + arg;
		
		System.out.println(lambdaTwo.howAreYouFeeling("Excellent"));
		
		// --------------------------- [방법 2] 인수로 사용 ---------------------------
		// 5-3. 
		Mood lambdaThree = new Person();
		System.out.println((lambdaThree = arg -> "[2.1] I feel like " + arg).howAreYouFeeling("so so"));
		
	}

}
