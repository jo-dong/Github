// #4

public class TypeEx02 {

	public static void main(String[] args) {
		
		boolean bool = true;
		System.out.println("bool >> " + bool);
		
		/*
		 * 자동 형 변환(묵시적 형 변환)
		 * 작 -> 큰, 정수 -> 실수
		 */
		
		int n1 = 10;
		int n2 = 3;
		double n3 = 3.0;
		System.out.println("n1 / n2 = " + n1 / n2);
		System.out.println("n1 / n2 = " + n1 / (double)n2);		// 강제로 n2의 자료형을 정수 -> 실수로 변환
		System.out.println("n1 / n3 = " + n1 / n3);
		
	}

}
