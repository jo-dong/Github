
public class MethodEx03 {

	// [Method 정의]
	// Method 형태 : 매개변수 O, 리턴값 O
	// 기능 : 정수를 2개 입력 받은 후, 덧셈한 결과를 리턴
	public static int add(int n1, int n2) {		// int n1, n2 → Syntax Error
		
		int result = n1 + n2;
		
		return result;			// 1. return을 만나면 Method 실행 종료(우선순위 더 높음) 
								// 2. body의 "}" 만나면 Method 실행 종료 		
	}
	
	
	// main Method
	public static void main(String[] args) {

		int addResult = add(5, 3);
		
		System.out.println("add(5, 3) 실행 결과 >> " + addResult);

		System.out.println("add(2, 4) 실행 결과 >> " + add(2, 4));
		
		add(1, 3); 		// 실행은 되지만 출력도 안되고 저장도 안되는 의미 없는 코드
		
	}

}
