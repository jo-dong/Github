
public class MethodEx02 {
	
	// [Method 정의]
	// Method 형태 : 매개변수 O, 리턴값 X
	// 기능 : 정수 1개를 받은 후, 1 증가된 값 출력
	public static void increment(int num) {		// 매개변수(Parameter) : 변수 선언의 형태로 넣어준다
		
		num++;
		System.out.println("1 증가된 값 >> " + num);
		
	}

//	------------------------------------------------------------------------------------
	
	// Method : main
	public static void main(String[] args) {		// 실행(Run)하면 main Method 먼저 실행

		increment(5);	// increment() Method에서 매개변수를 선언했기 때문에 호출할 때 인수(값,인자; Argument)를 적어야함, num = 5
		increment(10);
		
	}

}
