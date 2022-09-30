
public class ForQuiz01 {

	public static void main(String[] args) {

		// 중첩 for문 -> 2단의 짝수 행만 출력
		
		for (int i=2; i<3; i++) {			
			
			for (int j=1; j<11; j++) {				
				
				if (j % 2 == 1) 
					continue;
				
				System.out.println(i + " * " + j + " = " + (i * j));			
			
			}
			
		}
		
	}

}
