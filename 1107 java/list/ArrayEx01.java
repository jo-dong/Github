package list;

import java.util.Arrays;

public class ArrayEx01 {

	public static void main(String[] args) {

		// 1. 길이가 3인 배열 생성
		String[] str = new String[3];
		str[0] = "one";
		str[1] = "two";
		str[2] = "three";
//		str[3] = "four";			// Error! 배열은 3, element는 4개
		
		System.out.println("<< 배열 길이 3 >>");
		for(String s : str)
			System.out.print(s + " ");
		
		// 2. 길이가 4인 배열 생성
		String[] copy = Arrays.copyOf(str, 4);
		copy[3] = "four";
		
		System.out.println("\n<< 배열 길이 4 >>");
		
		for(String s : copy)
			System.out.print(s + " ");
		
		
	}

}
