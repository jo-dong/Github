
/*
 * Method Overloading
 * : 같은 이름의 Method를 중복하여 정의하는 것
 * 	 매개변수의 개수나 타입을 다르게 하면, 하나의 이름으로 메소드를 작성 가능
 *   But, 변수의 이름은 같아야함
 *   
 *   Ex)
 *   1. void display(int num1)
 *   	sysout(num1);
 *   2. void display(int num1, int num2)
 *   	sysout(num1 * num2);
 *   3. void display(int num1, double num2)
 *   	sysout(num1 + num2);
 *   
 *   호출
 *   1. display(10);		// 1번 display() Method 호출 -> 10
 *   2. display(10, 20);	// 2번 display() Method 호출 -> 200
 *   3. display(10, 3.14);	// 3번 display() Method 호출 -> 13.14
 *   4. display(10, 'a');	// 2, 3번 모두 호출 가능 	 -> 970
 *   						// 'a' 아스키코드 값 : 97(int) -> 10 * 97 = 970
 *   
 */

public class MethodEx05 {

	// [Method 정의]
	// 기능 : 정수 2개를 입력 받은 후, 덧셈한 결과를 출력
	public static void sum(int n1, int n2) {
		
		int result = n1 + n2;
		System.out.println("덧셈 결과 >> " + result);
		
	}
	
	public static void sum(double n1, double n2) {			
		
		double result = n1 * n2;
		System.out.println("곱셈 결과 >> " + result);
		
	}	
	
	public static void sum(int n1) {			
		
		
	}	
	
	public static void sum(int n1, double n2) {			
		
		
	}	
	
	public static void sum(double n1, int n2) {			
		
		
	}	
	
	// 모두 다 Overloading
	
	// main Method
	public static void main(String[] args) {

		sum(3, 5);
		sum(2.1, 4.5);		// n1, n2 = int → 자료형이 맞지 않아 Error
		System.out.println(5);
		System.out.println(5.1);
		System.out.println('c');
		System.out.println("안녕~");
		
	}

}
