/*
 * 1. 무한 루프문
 * - 문법 : while(true)
 * - 좋다, 나쁘다의 개념으로 접근하는 것이 아님
 * - 반드시, 반복문 내에 break를 명시해줘야 함
 * 
 * 2. break
 * - 반복문 내에서 조건문과 함께 사용됨
 * - 의미 : 반복문을 탈출
 */

public class WhileEx03 {

	public static void main(String[] args) {

		int idx = 1;
		
		// 무한 Loop : 반복의 횟수를 지금 정하기 어려울 때 사용
		while (true) {
			System.out.println("idx >> " + idx);
			
			if (idx == 3)	// 이 if문이 없으면 무한 반복
				break;
			
			idx++;
		}
		
		System.out.println("반복문 실행 종료");
		
	}

}
