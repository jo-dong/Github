
/*
 * [반복문] do ~ while 문
 * 	: 조건과 상관 없이 최소 1회 꼭 실행시키는 구문
 * 
 * 	do {
 * 		명령어;
 * 		명령어;
 * 	}
 * 	while (조건식);
 * 
 */

public class DoWhileEx01 {

	public static void main(String[] args) {

		int idx = 10;
		
		// [while]	: 조건이 맞지 않으면 시작도 하지 못하고 탈출
		while (idx < 10) {
			System.out.println("idx >> " + idx);
			idx++;
		}
		
		// [do-while문]
		do {
			System.out.println("idx >> " + idx);
			idx++;
		}
		while (idx < 13);
		
	}

}
