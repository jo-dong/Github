
/*
 * [반복문] For문
 * 	: (초기값)이 (조건식)에 부합할 때까지 (증감식)을 반복
 * 
 * 	for (초기값; 조건식; 증감식) {
 * 		명령어;
 *  }
 */

public class ForEx01 {

	public static void main(String[] args) {

		// [while]
		int idx = 1;		// 초기값
		
		while (idx < 4) {	// 조건식
			System.out.println("idx >> " + idx);
			idx++;			// 증감식
		}
		
		System.out.println("-------------");
		
		// [for]
		for (idx = 1; idx < 4; idx++) {
			System.out.println("idx >> " + idx);
		}
		
	}

}
