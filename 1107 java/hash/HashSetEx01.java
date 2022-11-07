package hash;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx01 {

	public static void main(String[] args) {
		
		// 저장 속도는 일반적으로 List < HashSet (순서 상관 없이 데이터를 채우기 때문)

		HashSet<String> hashSet = new HashSet<String>();
		
		// 저장된 요소 존재 여부
		System.out.println("비어 있나요? >> " + hashSet.isEmpty());
		
		// 요소 추가
		hashSet.add("하나");
		hashSet.add("둘");
		hashSet.add("셋");
		hashSet.add("하나");
		
		// 특정 위치에 저장된 요소 출력
//		System.out.println("index=0 >> " + hashSet.get(0));		// hashSet은 순서 보장 안해줌 => index 없음
		
		// 요소 개수
		System.out.println("저장된 요소 개수 >> " + hashSet.size());
		
		// 객체 포함(존재) 여부
		System.out.println("둘 있나요? >> " + hashSet.contains("둘"));
		System.out.println("넷 있나요? >> " + hashSet.contains("넷"));
		
		// [저장된 요소 전부 출력 1]
		System.out.println("\n<< 전체 요소 출력 1 >>");
		for(Object str : hashSet.toArray())
			System.out.print(str + " ");	// output : 둘 하나 셋 	>> 순서 보장 X, 중복 허용 X
		
		// [저장된 요소 전부 출력 2]
		System.out.println("\n<< 전체 요소 출력 2 >>");
		for(String str : hashSet)
			System.out.print(str + " ");
		
		// [저장된 요소 전부 출력 3]
		System.out.println("\n<< 전체 요소 출력 3 >>");
		Iterator<String> iter = hashSet.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		
		/*
		 * [중복값 허용 X]
		 *  : HashSet은 요소를 추가하기 전에 저장된 요소 값과 비교
		 *  1. hashCode() - hash 값(숫자)이 같은지 우선 비교
		 *  2. equals()	- 문자열이 서로 같은지 다시 비교
		 *  
		 *  So,,
		 *  중복 없이 요소를 추가하기 위해서는
		 *  hashCode(), equals() Method를 상황에 맞추어 Overriding !!
		 */
		
		// 요소 추가 : 둘
		System.out.println("\n\n\'둘\' 요소 추가 >> " + hashSet.add("둘"));
		System.out.println("요소 추가 후 길이 >> " + hashSet.size());

		// 요소 '둘'의 hash 값
		System.out.println("\n<< 문자열의 hashCode >>");
		System.out.println("\'하나\' hashCode() >> " + "하나".hashCode());
		System.out.println("\'둘\' hashCode() >> " + "둘".hashCode());
		System.out.println("\'셋\' hashCode() >> " + "셋".hashCode());
		System.out.println("\'a\' hashCode() >> " + "a".hashCode());
		System.out.println("\'b\' hashCode() >> " + "b".hashCode());
		System.out.println("\'love\' hashCode() >> " + "love".hashCode());
		System.out.println("\'Love\' hashCode() >> " + "Love".hashCode());
		
		// 저장된 요소의 hash 값
		System.out.println("\n<< 저장된 요소의 hashCode >>");
		iter = hashSet.iterator();
		String s;
		while(iter.hasNext()) {
			s = iter.next();
			System.out.println(s + " >> " + s.hashCode()); 		
//			System.out.println(iter.next() + " >> " + iter.next().hashCode());
			// Error! next()를 2번 사용해서 index가 2번씩 증가함
		}
		
	}

}
