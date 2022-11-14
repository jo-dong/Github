package functionalinterface;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerEx01 {
	
	// ex)
		void show(String str) {
			System.out.println(str);
		}

	public static void main(String[] args) {

		// Consumer<T> ===========================================
		// accept(T t) : parameter 1개 (O), return (X)
		// Lambda : (parameter) -> expression / No return
		// =======================================================
		
		Consumer<String> consumer = str -> System.out.println(str.split(" ")[1]);
		consumer.accept("Oh, Happy Day");				// Oh, Happy Day 전부 출력
//		consumer.accept("Oh, Happy Day".split(" ")[1]);	// Happy만 출력
		
		// 출력을 해야 이해가 쉬우니까 억지로 한 것이지 원래 accept()가 출력을 하는 애는 아님
		// 하지만 구조가 위의 show 메소드와 동일(매개변수 1, 리턴 X)
		
		
//		===============================================================================
		
		// cf) 문자열.split();
		// 1차원 배열의 주소 출력
		System.out.println("-------------\n" + "문자열 나누기 작업 중".split(" ")); 	
		
		String[] s = "문자열 나누기 작업 중".split(" ");
		System.out.println("s[0] >> " + "문자열 나누기 작업 중".split(" ")[0]);
		System.out.println(Arrays.toString(s));		// s 배열 내 컨텐츠 모두 확인
		System.out.println("s[1] >> " + s[1]);
		
		// 문자열을 공백 기준으로 2개로 나누세요
		String[] s2 = "문자열 나누기 작업 중".split(" ", 2);
		System.out.println(Arrays.toString(s2));
		
		// 문자열을 공백 기준으로 10개로 나누세요
		// 나눌 수 있는 만큼만 나눔(최대 4개)
		String[] s3 = "문자열 나누기 작업 중".split(" ", 10);
		System.out.println(Arrays.toString(s3));
		
	}
	

}
