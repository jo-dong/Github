
public class ArrayEx01CleanCode {

	public static void main(String[] args) {

		// [우리 반 학생들의 수학 점수 저장]
		
		// 1. 배열 생성 & 객체 생성 & 초기화
		int[] math = {90, 95, 85, 70, 100};				// 자동으로 length = 5 / math[0] = 90 ... math[4] = 100
//		int[] math = new int[] {90, 95, 85, 70, 100};	// new int[] 생략 가능
		
		// 2. 배열 요소 값 확인 -> for문
			
			// 2-1. 일반 for문
		for(int i=0; i<math.length; i++) {
			System.out.printf("math[%d] = %d\n", i, math[i]);
		}
		
		System.out.println("배열의 길이 >> " + math.length);
		
			// ★★★ 2-2. 향상된 for문		
		for(int element : math) {
			System.out.println(element);
		}
		
	}

}
