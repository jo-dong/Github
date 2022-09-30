
public class NestedLoopQuiz02 {

	public static void main(String[] args) {

		// 중첩 while문 -> 구구단 2 ~ 9단 출력
		
		int i = 2;
				
		while (i <= 9) {			
			int j = 1;
			
			while (j <= 9) {				
				System.out.println(i + " * " + j + " = " + (i * j));
				
				j++;
			}			
			
			i++;
			
			System.out.println();
		}
		
	}

}
