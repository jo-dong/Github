package lambda;

@FunctionalInterface
interface MaxReturn {
	// abstract method
	int max(int n1, int n2);
	
	// instance method
	default void method(int n1, int n2) {
		System.out.printf("parameter n1 : %d, n2 : %d\n", n1, n2);
	}
}

class SubMaxReturn implements MaxReturn {
	@Override
	public int max(int n1, int n2) {
		return (n1 > n2) ? n1 : n2;
	}
}

public class LambdaEx05 {

	public static void main(String[] args) {
		
		// 1. create object - polymorphism
		MaxReturn maxReturn = new SubMaxReturn();
		int max = maxReturn.max(5, 2);
		System.out.println("[Polymorphism] Max Number : " + max);
		
		// [Q1] Anonymous Class : 참조 변수에 저장
		MaxReturn maxAnonymous = new MaxReturn() {
			@Override
			public int max(int n1, int n2) {
				return (n1 > n2) ? n1 : n2;
			}
		};
		System.out.println("\n[Anonymous Class 1] : " + maxAnonymous.max(4, 8));
		
		// [Q2] Anonymous Class : 바로 출력
		System.out.println("[Anonymous Class 2] : " + new MaxReturn() {
			@Override
			public int max(int n1, int n2) {
				return (n1 > n2) ? n1 : n2;
			}
		}.max(10, 20));
		
		// [Q3] Lambda Expression - 참조 변수에 저장
		MaxReturn maxLambda = (n1, n2) -> (n1 > n2) ? n1 : n2;
		System.out.println("\n[Lambda 1] : " + maxLambda.max(871, 936));

	}

}
