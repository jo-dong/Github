
public class ArrayEx02 {

	public static void main(String[] args) {

		// 1차원 배열(행이 1개) 생성 : int형의 길이가 5인 배열 arr 생성
		// 자료형[] + 배열명(참조변수) = (new + 자료형[]) {값1, 값2, ...};
		
		int[] arr = new int[] {2, 4, 6, 8, 10};
		
		// 1. 2차원 배열(like Table) 생성
		
		int[][] arr2 = new int[2][3];		// [2] = 행, [3] = 열 / 순서 : [0][0], [0][1], [0][2]
		// 길이가 3인 1차원 배열이 2개와 같은 의미				//		   [1][0], [1][1], [1][2]
		
		// 2. 2차원 배열에 값 설정
		arr2[0][0] = 2;
		arr2[0][1] = 4;
		arr2[0][2] = 6;
		arr2[1][0] = 8;
		arr2[1][1] = 10;
		arr2[1][2] = 12;
		
		// cf)			cf(confer) : 무언가를 비교하기 위해 사용
		// arr2    : 참조변수 - 행의 시작 주소
		// arr2[0] : 참조변수 - 첫 번째 1차원 배열의 시작 주소
		// arr2[1] : 참조변수 - 두 번째 1차원 배열의 시작 주소
		
		System.out.println("<< arr2의 주소 >> \n");
		System.out.println("arr2 >> " + arr2);
		System.out.println("arr2[0] >> " + arr2[0]);
		System.out.println("arr2[1] >> " + arr2[1]);
		// output : arr2 >> [[I@123772c4				[[ : 2차원 배열  
		// 			arr2[0] >> [I@2d363fb3				I : 자료형(Type)(Integer라는 Class) 
		//          arr2[1] >> [I@7d6f77cc				7d6f77cc : 16진수로 나타낸 주소
		
		System.out.println("\n<< 일반 for문 >>\n");
		
		// 3. 배열 요소의 값 출력
		// 3-1. 일반 for문
		for(int i=0; i<arr2.length; i++) {			// 행	무조건 행부터 검색
			for(int j=0; j<arr2[i].length; j++) {	// 열
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n<< 향상된 for문 >>\n");
		
		// 3-2. 향상된 for문
		
		// for(자료형 변수명 : 배열명) {
		//		for(자료형 변수명 : 배열명)
		//			명령어;
		// }
		
		for (int[] out : arr2) {
			for (int in : out) {
				System.out.print(in + " ");
			}
			System.out.println();
		}
		
	}

}

