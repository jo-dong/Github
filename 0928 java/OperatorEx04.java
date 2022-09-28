// #4

public class OperatorEx04 {

	public static void main(String[] args) {

		// 1) 선증가
		int num1 = 7;
		int num2, num3;
		
		num2 = ++num1;		// num2에 num1 + 1 = 8, ++num1 = 8 
		num3 = --num1;		// num3에 num1 - 1 = 7, --num1 = 7
		
		System.out.println("num1 : " + num1); // num1 = 7
		System.out.println("num2 : " + num2); // num2 = 8
		System.out.println("num3 : " + num3); // num3 = 7
		
		// 2) 후증가
		int n1 = 7;
		int n2, n3;
		
		n2 = n1++;		// n2에 n1 그대로 저장 = 7, n1++ = 8 
		n3 = n1--;		// n3에 n1 그대로 저장 = 8, n1-- = 7
		
		System.out.println("n1 : " + n1); // n1 = 7
		System.out.println("n2 : " + n2); // n2 = 7
		System.out.println("n3 : " + n3); // n3 = 8
	}

}




