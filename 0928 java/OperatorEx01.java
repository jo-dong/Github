// 09.28 #1

/*
 * [산술 연산자]
 * 덧셈 : +
 * 뺄셈 : -
 * 곱셈 : *
 * 나눗셈(몫) : /
 * 나머지 : % (짝수, 홀수 구분할 때 많이 사용)
 * 
 * [대입 연산자]
 * a += b : a + b 한 값을 a에 저장
 * a -= b
 * a *= b
 * a /= b
 * a %= b
 */


public class OperatorEx01 {

	public static void main(String[] args) {

//		int num1 = 5;
//		int num2 = 3;
		int num1 = 5, num2 = 3;
		
		System.out.println("덧셈 >> " + num1 + num2);  // 덧셈 >> 53 출력
//							String		int	   int		>> 다 String으로 형 변환시킴(좌측에서 우측으로 처리)		
		System.out.println("덧셈 >> " + (num1 + num2));  // 덧셈 >> 8 출력		
		System.out.println(num1 + num2 + " >> 덧셈"); // 8 >> 덧셈 : 좌측에서 먼저 처리하기 때문에 int를 먼저 만나 8이 출력
		

		//		System.out.println("뺄셈 >> " + num1 - num2); -> Error : 맨 좌측 String + num1(String으로 간주) - num2(int)
//																 String과 int 사이에 - 연산은 정의가 되어있지 않음
		System.out.println("뺄셈 >> " + (num1 - num2));
		
		
		System.out.println("곱셈 >> " + num1 * num2);	// +, * : 우선순위가 *이 먼저이기 때문에 괄호가 없어도 됨
		
		
		System.out.println("몫 >> " + num1 / num2);
		
		
		System.out.println("나머지 >> " + num1 % num2);
		
	}

}
