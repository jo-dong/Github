package inner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnonymousInnerClassEx04 {

	public static void main(String[] args) {

		// ArrayList 생성
		ArrayList<String> hangul = new ArrayList<String>();
		
		hangul.add("바람");
		hangul.add("하늘");
		hangul.add("돌");
		hangul.add("나비");
		
		System.out.println("[정렬 전]\n: " + hangul);
		// output : [하늘, 바람, 돌, 나비]		: String은 기본적으로 .toString 되어서 나옴
		// 원래 hangul은 주소 출력 - 문자열이라 하늘 바람...이 나오는 것
		
		// cf) 1차원 배열 =============================================================
//		String[] str = {"바람", "하늘", "돌", "나비"};
//		System.out.println(str);		// str의 주소 출력
//		System.out.println("\n[배열을 문자열로 출력]\n: " + Arrays.toString(str));
		// ===========================================================================
		
		// ===========================================================================
		// [오름차순 정렬 1] - Collections.sort(List);
		// ===========================================================================
		Collections.sort(hangul);		// ㄱㄴㄷ 순으로 정렬 / index 위치도 다 바뀜
		System.out.println("\n[오름차순 1 정렬 후]\n: " + hangul);
		
		// ===========================================================================
		// [내림차순 정렬 1] - Collections.sort(List, Collections.reverseOrder());
		//  : 오름차순으로 정렬 후 역순
		// ===========================================================================
		Collections.sort(hangul, Collections.reverseOrder());
		System.out.println("\n[내림차순 1 정렬 후]\n: " + hangul);
		
		// ===========================================================================
		// [오름차순 정렬 2] - List.sort(Comparator.naturalOrder()); 		: Java 8 이후
		// ===========================================================================
		hangul.sort(Comparator.naturalOrder());
		System.out.println("\n[오름차순 2 정렬 후]\n: " + hangul);
		
		// ===========================================================================
		// [내림차순 정렬 2] - List.sort(Comparator.reverseOrder());
		//  : 오름차순으로 정렬 후 역순
		// ===========================================================================
		hangul.sort(Comparator.reverseOrder());
		System.out.println("\n[내림차순 2 정렬 후]\n: " + hangul);
		
		// ===========================================================================
		// [오름차순 정렬 3] - 사용자 정의 : Comparator 인터페이스
		//  : interface Comparator<String> 를 구현 
		//  : 클래스 없이 객체(인스턴스)화 => Anonymous Class
		//  
		//  -> 첫 번째 파라미터 > 두 번째 파라미터 : 양수 => 기준 크다, 자리 바꿈 O
		//  -> 첫 번째 파라미터 < 두 번째 파라미터 : 음수 => 기준 작다, 자리 바꿈 X
		//  -> 첫 번째 파라미터 = 두 번째 파라미터 :  0  => 서로 같다, 자리 바꿈 X
		//
		//  => Bubble 정렬
		//  : 1회전 시 제일 큰 수 확정
		// ===========================================================================
				// 3-1. Anonymous Class 생성
				// 		Comparator는 interface : 객체 생성 불가 
				// 		=> Anonymous Class 생성 -> Overriding
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			// Bubble 정렬하는 method
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);	// 오름차순 - 기준이 s1
//				return s2.compareTo(s1);	// 내림차순 - 기준이 s2
			}
		};
				// 3-2. 오름차순 정렬
		hangul.sort(comparator);
		System.out.println("\n[오름차순 3 정렬 후]\n: " + hangul);
		
		// cf) compareTo() method
		System.out.println("\nA와 B 비교 >> " + "A".compareTo("B"));
		// output : -1 ==> 문자열 비교 시 ASCII Code 이용
		System.out.println("\nB와 A 비교 >> " + "B".compareTo("A"));
		// output : 1 ==> 'A' = 65, 'B' = 66
		System.out.println("\nA와 a 비교 >> " + "A".compareTo("a"));
		// output : -32 ==> 'A' = 65, 'B' = 97 : 대문자와 소문자는 항상 |32| 차이
		System.out.println("\nHello과 Hell 비교 >> " + "Hello".compareTo("Hell"));
		// output : 1 ==> 비슷하게 생기면 length 뺄셈
		System.out.println("\nHello과 Hi 비교 >> " + "Hello".compareTo("Hi"));
		// output : -4 ==> 두 번째 문자 e, i 사이의 ASCII Code 비교(e = 101, i = 105) 
		
	}

}
