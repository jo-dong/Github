package method.reference.expression;

import java.util.function.Function;

interface Greeting {
	// abstract method
	int say(String str);
}

public class Quiz01 {

	public static void main(String[] args) {

		// [Q1] Anonymous Class
		Greeting greetOne = new Greeting() {
			@Override
			public int say(String str) {
				return str.length();
			}
		};
		System.out.println("[1. Anonymous class] 문자열 길이 >> " + greetOne.say("Hello"));
		
		// [Q2] Lambda Expression - 참조 변수에 저장
		Greeting greetTwo = str -> str.length();
		System.out.println("[2. Lambda Expression] 문자열 길이 >> " + greetTwo.say("Hello"));
		
		// [Q3] Generic Functional Interface - Lambda : 참조 변수에 저장
		Function<String, Integer> greetThree = str -> str.length();
		System.out.print("[3. Generic Functional Interface]");
		System.out.println(" 문자열 길이 >> " + greetThree.apply("Hello"));
		
		// [Q4] Generic Functional Interface : 메서드 참조
		Function<String, Integer> greetFour = greetOne::say;
		System.out.print("[4. Method Reference Expression]");
		System.out.println(" 문자열 길이 >> " + greetFour.apply("Hello"));
		
		// Q4 강사님 답 --------------------------------------------------------
		Function<String, Integer> greetReference = String::length;
		System.out.print("[4. Method Reference Expression]");
		System.out.println(" 문자열 길이 >> " + greetReference.apply("Hello"));
	}

}
