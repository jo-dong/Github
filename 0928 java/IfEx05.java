
public class IfEx05 {

	public static void main(String[] args) {

		// 랜덤 값 생성
		System.out.println("0 ~ 1 실수 랜덤 생성 : " + Math.random()); 
			// random 값의 자료형 : double(실수; 0이상 1미만)
		
		// 랜덤 값 * 상수
		System.out.println("0 ~ 3 실수 랜덤 생성 : " + Math.random() * 3);
			// 0.xxxx, 1.xxxx, 2.xxxx, ... (double) 
			// 강제 형변환
			// 0, 1, 2 (int)
		// 랜덤 값을 형변환하여 정수로 만들기
		System.out.println("0 ~ 2 정수 랜덤 생성 : " + (int)(Math.random() * 3));

		// 1 ~ 3 랜덤 정수 출력
		int randomValue = (int)(Math.random() * 3) + 1;
		System.out.println("1 ~ 3 정수 랜덤 생성 : " + randomValue);	
		
		
		// 1 ~ 5 랜덤 정수 출력
		int randomValue1 = (int)(Math.random() * 5) + 1;
//		if (randomValue1 == 1) {
//			System.out.println("1번이 나왔습니다.");
//		}
//		else if (randomValue1 == 2) {
//			System.out.println("2번이 나왔습니다.");
//		}
//		else if (randomValue1 == 3) {
//			System.out.println("3번이 나왔습니다.");
//		}
//		else if (randomValue1 == 4) {
//			System.out.println("4번이 나왔습니다.");
//		}
//		else {
//			System.out.println("5번이 나왔습니다.");
//		}
		
		System.out.println(randomValue1 + "번이 나왔습니다.");
		
	}

}
