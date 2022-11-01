package stringexample;

public class Ex01 {

	public static void main(String[] args) {

		String[] str = {"one", "two", "three", "four"};
		String concat = ""; 	// 빈 문자열 : 배열 내의 컨텐츠들을 이어줄 때 사용
		
		// 1. 일반 for문
		for(int i=0; i<str.length; i++) {
//			System.out.println(str[i] + ", ");
			concat += str[i] + ", ";	// concat = concat + str[i] + ", ";
		}
		System.out.println("concat >> " + concat);
		
		// 2. 향상된 for문
		for(String c : str)
			System.out.print(c + ", ");
		
	}

}
