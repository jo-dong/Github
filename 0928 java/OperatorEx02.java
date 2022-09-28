// #2

public class OperatorEx02 {

	public static void main(String[] args) {

		// [복합 대입 연산자]
		int n1 = 5, n2 = 3;
		
		n1 = n1 + n2;
		// n1 + n2 한 값을 n1에 저장
		// n1 += n2; 와 같다
		System.out.println("n1 >> " + n1);
		System.out.println("n2 >> " + n2);
		
		
		// [관계 연산자] 결과 : true or false
		System.out.println("크니 ? : " + (n1 > n2));
		System.out.println("다르니 ? : " + (n1 != n2));
		System.out.println("같니 ? : " + (n1 == n2));
		
		
		// [논리 연산자] : 집합(AND(&&), OR(||), NOT(!))
		boolean result1 = (n1 == 5 && n2 == 3);
		boolean result2 = (n1 == 5 || n2 == 3);
		
		System.out.println("result1 >> " + result1);
		System.out.println("result2 >> " + result2);
		
		
	}

}



