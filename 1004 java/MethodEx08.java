
public class MethodEx08 {

	public static void main(String[] args) {

		System.out.println("Practice Refactoring");
		
		increment();
		
	}

	public static void increment() {
		int num = 10;
		num++;
		System.out.println(num);		// 같은 이름의 변수를 한 번에 바꾸기 = Alt + Shift + R (2번)
	}

}

// int num = 10;
// num++;
// System.out.println(num);		블럭 지정 후 Alt + Shift + M -> 자동으로 메소드 생성
