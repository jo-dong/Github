// #3

/*
 * [증가/감소 연산자]
 * prefix (1을 더하고 변수 호출)
 * ++n : 피연산자의 값 1 증가
 * --n : 피연산자의 값 1 감소
 * 
 * postfix (일단 호출 후 1 더함)
 * n++ : 피연산자의 값 1 증가
 * n-- : 피연산자의 값 1 감소
 */

public class OperatorEx03 {

	public static void main(String[] args) {

		// [증감 연산자]
		int num = 5;
		
		// num++;			// 1 증가 연산자 (결과는 ++num과 같다)
		// int result = ++num;	// 선증가 prefix : num = 6, result = 6		// 선증가 연산자 ++ 가 우선 순위가 높음
		int result = num++;		// 후증가 postfix : num = 6, result = 5		// 대입 연산자 = 가 우선 순위가 높음
		// int result = num;
		// num = num + 1;		과 같음
		
		System.out.println("num >> " + num);
		System.out.println("result >> " + result);
		
	}

}
