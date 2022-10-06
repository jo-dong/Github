
public class ArrayEx02CleanCode {

	public static void main(String[] args) {

		// 1. 2차원 배열 생성 & 객체 생성 & 초기화
		
		int[][] arr2 = {{2, 4, 6},{8, 10, 12}};
		
		// 2. 배열의 주소 확인
		
		System.out.println("<< arr2의 주소 >> \n");
		
		System.out.println("arr2 >> " + arr2);
		System.out.println("arr2[0] >> " + arr2[0]);
		System.out.println("arr2[1] >> " + arr2[1]);
		
		System.out.println("\n<< 일반 for문 >>\n");
		
		// 3. 배열 요소의 값 출력
		// 3-1. 일반 for문
		for(int i=0; i<arr2.length; i++) {			
			for(int j=0; j<arr2[i].length; j++) {	
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n<< 향상된 for문 >>\n");
		
		// 3-2. 향상된 for문(Enhanced for Loop)
		
		for (int[] out : arr2) {
			for (int in : out) {
				System.out.print(in + " ");
			}
			System.out.println();
		}
		
	}

}

