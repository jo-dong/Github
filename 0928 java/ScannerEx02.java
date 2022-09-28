// #7

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {

		// 1. Scanner 객체 생성
		Scanner input = new Scanner(System.in);
		
		// 2-1. 문자열 입력 - next() , 최초 공백 이전까지 
		System.out.println("문자열 1개 입력");
		String s1 = input.next();
		System.out.println("입력된 문자열 : " + s1);
		
		input.nextLine();					// § 2-1과 2-2를 순차적으로 실행시키기 위해 삽입.
		
		// 2-2. 문자열 입력 - nextLine() , 엔터 치기 전까지
		System.out.println("문자열 입력");
		String s2 = input.nextLine();
		System.out.println("입력된 문자열 : " + s2);
		
	}

}
