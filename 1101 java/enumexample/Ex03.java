package enumexample;

enum Number {
	ONE(1), TWO(2), THREE(3), FOUR(4);		// semi colon도 없어도 됨(다른 코드들이 없을 때)
	
	// 배열 index 변경
	private int number;
	
	private Number(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
}

public class Ex03 {

	public static void main(String[] args) {

		Number currentNumber = Number.ONE;
		
		switch(currentNumber) {
		case ONE :
			System.out.println("ONE >> 1");
			break;
		case TWO :
			System.out.println("TWO >> 2");
			break;
		case THREE :
			System.out.println("THREE >> 3");
			break;
		case FOUR :
			System.out.println("FOUR >> 4");
			break;
		}
		// ---------------------------------------------------------
		System.out.println("<< 배열 contents 출력 >>");
		for(Number n : Number.values())
			System.out.print(n + " ");
		
		System.out.println();
		// ---------------------------------------------------------
		System.out.println("<< 서수 출력(변경 전) >>");
		for(Number n : Number.values())			
			System.out.print(n.ordinal() + " ");	// field 값 출력 이라고도 함
		
		System.out.println();
		// ---------------------------------------------------------
		System.out.println("<< 서수 출력(변경 후) >>");
		for(Number n : Number.values())
			System.out.print(n.getNumber() + " ");
	}

}
