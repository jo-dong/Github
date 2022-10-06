
/*
 * [배열, Array]
 *  : 하나의 이름으로 여러 값(요소, 원소; Element)을 관리
 *  : 여러 값을 구분하기 위해 인덱스 사용  --> 인덱스는 0부터 시작
 * 
 *  : Java는 배열을 무조건 객체로 생성함 --> Heap 영역에 생성
 *  	그래서 주소로 접근 (간접 접근)
 *  
 *  (문법)
 *  : 자료형[] 배열명 = new 자료형[length];
 *  
 *  : 배열을 생성하면, 배열의 길이가 length 변수에 저장
 *   --> (문법) : 배열명.length
 *   --> length는 변경 불가능 (ex)math.length = 5 (X)
 *   
 *  
 */

public class ArrayEx01 {

	public static void main(String[] args) {

		// [우리 반 학생들의 수학 점수 저장]

//		int math01 = 80;
//		int math02 = 95;
//		int math03 = 90;		// 이렇게 안함
//		int math04 = 70;
//		int math05 = 100;
		
		// 1. 배열 생성
		int[] math;		// = int math[];		: int형 배열의 주소가 참조변수 math에 저장
						// 자료형[] + 변수명(배열명; 참조변수); 
		
		// 2. 객체 생성 : new + 자료형[길이(length)];
		math = new int[5];		// int형으로 5개의 배열(길이가 5인)을 Heap 영역에 할당
								// -> 변수 math(stack)에 주소 저장
								// math.length = 5 (0, 1, 2, 3, 4)
		
		// 3. 배열 요소에 값 설정
		math[0] = 90;
		math[1] = 95;
		math[2] = 85;
		math[3] = 70;
		math[4] = 100;
		
		// 4. 배열 요소의 값 확인 -> 반복문 : while, for(for 권장)
//		System.out.println("math[0] >> " + math[0]);
//		System.out.println("math[1] >> " + math[1]);
//		System.out.println("math[2] >> " + math[2]);
//		System.out.println("math[3] >> " + math[3]);
//		System.out.println("math[4] >> " + math[4]);
		
		// 일반 for문
		for(int i=0; i<math.length; i++) {
			System.out.printf("math[%d] = %d\n", i, math[i]);
		}
		
		System.out.println("배열의 길이 >> " + math.length);
		
		// ★★★ 5. 향상된 for문 : 쉽게 표현된 for문 (배열에서만 사용) 
		
		// for(자료형 + 변수명 : 참조변수) {	// 초기값, 조건식, 증감식 없음
		//		명령어;
		// }
		
		for(int element : math) {
			System.out.println(element);
		}
		
	}

}
