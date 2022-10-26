
public class ArrayEx01 {

	public static void main(String[] args) {

		// 배열 생성과 동시에 초기화
		// int[][] arr = {{2, 4, 6} , {8, 10}};
		
		// 행은 꼭 넣어야됨(열은 안넣어도 됨)
		int[][] arr = new int[2][];
		
		arr[0] = new int[] {1, 2, 3};
		arr[1] = new int[] {4, 5, 6, 7};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
