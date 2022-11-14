package functionalinterface;

import java.util.function.Function;

public class FunctionEx01 {

	public static void main(String[] args) {

		// Function<T, R> ========================================
		// apply(T t)	: parameter 1개 (O), return (O)
		// Lambda		: (parameter) -> expression
		// =======================================================
		
		// [Lambda 1] : 정수를 1개 받아서, 문자열 리턴
		Function<Integer, String> one = (num) -> "매개변수 값 : " + num;
		String value = one.apply(5);
		System.out.println("리턴된 문자열 >> " + value);
		
		// [Lambda 2] : 정수를 1개 받아서, 정수 리턴
		Function<Integer, Integer> square = num -> num * num;
		System.out.println("apply() : 제곱 >> " + square.apply(6));
		
		Function<Integer, Integer> increment = num -> num + 1;
		System.out.println("apply() : 1 증가 >> " + increment.apply(6));
		
//		============================== 연쇄 처리 ==============================
//		---------- andThen(Function<? super R,? extends V> after) ----------
		// 제곱 후 1 증가
		System.out.println(square.andThen(increment).apply(7));
		// square 먼저 계산되고 andThen(increment)가 다음에 계산된다.
		
		// 1 증가 후 제곱
		System.out.println(increment.andThen(square).apply(7));
		
//		---------- compose(Function<? super V,? extends T> before) ----------
		// 1 증가 후 제곱
		System.out.println(square.compose(increment).apply(8));
		
		// 제곱 후 1 증가
		System.out.println(increment.compose(square).apply(8));
//		=====================================================================
		
//		---------------------------- identity() ----------------------------
		// static <T> Function<T,T>		: static method
		// return t -> t; 				: 자기 자신 return
		Function<Integer, Integer> identityOne = Function.identity();
		Function<Integer, Integer> identityTwo = Function.identity();
		Function<Integer, Integer> identityThree = Function.identity();
		System.out.println(identityOne);		// static 내에 identity() 객체 단 하나 생성
		System.out.println(identityTwo);		// 주소가 모두 동일
		System.out.println(identityThree);
		
		Function<Integer, Integer> lambdaOne = t -> t;
		Function<Integer, Integer> lambdaTwo = t -> t;
		Function<Integer, Integer> lambdaThree = t -> t;
		System.out.println("\n" + lambdaOne);	// 매번 객체 새로 생성
		System.out.println(lambdaTwo);			// 주소가 모두 다름
		System.out.println(lambdaThree);
		
	}

}
