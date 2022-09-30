
public class NestedLoopQuiz01 {

	public static void main(String[] args) {

		// 중첩 for문 -> 구구단 2 ~ 9단 출력
		
		for (int i=2; i<10; i++) {
			System.out.println(i + "단");
			
			for (int j=1; j<10; j++) 
				System.out.println(i + " * " + j + " = " + (i * j));			
			
			System.out.println();
			
		}
		
	}

}
