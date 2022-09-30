
public class NestedLoopEx01 {

	public static void main(String[] args) {

		// 중첩 for문
		outer:	// break outer : break를 만나면 바깥 for문까지 벗어남
		for (int i=0; i<3; i++) {
			System.out.println("*** 바깥쪽 for문 " + (i + 1) + "차 회전 ***");
			
			for (int j=0; j<3; j++) {
				System.out.println("안쪽 for문 " + (j + 1) + "차 회전");			
				
				if (i % 2 == 0) {
					break outer;
				}
			}
//			System.out.println("j >> " + j);
			
			System.out.println();
		}
		
	}

}
