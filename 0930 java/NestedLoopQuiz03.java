
public class NestedLoopQuiz03 {

	public static void main(String[] args) {

		// 중첩 for문 -> 다음과 같은 형태 출력
		/*
		 * 		100
		 * 		010
		 * 		001
		 */
		
		int i, j;
				
		for (i=0; i<1; i++) {
			for (j=0; j<3; j++) {
				if (i == j) {
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
			}
		}
		
		System.out.println();
		
		for (i=1; i<2; i++) {
			for (j=0; j<3; j++) {
				if (i == j) {
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
			}
		}
		
		System.out.println();
		
		for (i=2; i<3; i++) {
			for (j=0; j<3; j++) {
				if (i == j) {
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
			}
		}
		
	}

}
