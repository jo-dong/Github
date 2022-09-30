import java.util.Scanner;

public class NestedLoopQuiz04 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.print("짝수 단 : 0, 홀수 단 : 1 >> ");
						
		int userNum = 0;
		userNum = input.nextInt();
		
		for (int i=2; i<10; i++) {			
			
			if (userNum == 0) {
				if (i % 2 == 1) {
					continue;
				}
			}
			else if (userNum == 1) {
				if (i % 2 == 0) {
					continue;
				}
			}				
			
			for (int j=1; j<10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));			
			}
			System.out.println();
		}
		
	}

}
