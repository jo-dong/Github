

public class P5 {

	public static void main(String[] args) {

		// 길이가 10인 1차원 배열 생성
		// 랜덤값(정수)을 저장
		// 저장된 정수의 빈도수 출력
		
		int i = 0;
		
		int random0 = (int)(Math.random()*9)+1;
		int random1 = (int)(Math.random()*9)+1;
		int random2 = (int)(Math.random()*9)+1;
		int random3 = (int)(Math.random()*9)+1;
		int random4 = (int)(Math.random()*9)+1;
		int random5 = (int)(Math.random()*9)+1;
		int random6 = (int)(Math.random()*9)+1;
		int random7 = (int)(Math.random()*9)+1;
		int random8 = (int)(Math.random()*9)+1;
		int random9 = (int)(Math.random()*9)+1;
		
		int[] arr = new int[] {random0,
							   random1,
							   random2,
							   random3,
							   random4,
							   random5,
							   random6,
							   random7,
							   random8,
							   random9};
		while(i<arr.length) {
			for(i=0; i<arr.length; i++) {
				System.out.print(arr[i]);
				if()
			}
			System.out.println();
		}
		
		
	}

}
