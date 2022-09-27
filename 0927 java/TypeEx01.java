// #3

public class TypeEx01 {

	public static void main(String[] args) {
		// 정수 자료형
		// byte by = 5.5; → Error
		// byte by = 130; → Error
		byte by = 5;		
		System.out.println("by >> " + by);
		
		by = 7;
		System.out.println("by >> " + by);
		
		char ch = 65;
		System.out.println("ch >> " + ch);
		// char 아스키 코드 
		// char ch = 65 : 65에 해당하는 ASCII 코드 값 = A 출력
		
		short sh = 97;
		System.out.println("sh >> " + sh);
		
		// long lo = 10000000000; → Error
		// 상수의 기본 타입 : int / 10000000000은 int의 범위를 벗어남
		// 상수 기본 타입 바꾸기 : 뒤에 Long의 L 붙임
		long lo = 10000000000L;
		System.out.println("lo >> " + lo);
		
		
		// 실수형
		// float fo = 3.14; Error 
		// 3.14의 기본 타입 : double
		float fo = 3.14F;
		// float fo_two = (float)3.14; 이것도 가능
		System.out.println("fo >> " + fo);
		
		double db = 3.14;
		System.out.println("db >> " + db);
	}

}
