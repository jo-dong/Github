/*
 * key : 값을 정하는 기준, 중복이 되면 안된다!
 */

package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {

		HashMap<String, Integer> hashMap = new HashMap<>();
		
		// 요소 저장 - put()
		hashMap.put("하나", 1);
		hashMap.put("둘", 2);
		hashMap.put("셋", 3);
		hashMap.put("하나", 1);	// key가 같으면 중복 허용 X / value는 같아도 상관 없음
		hashMap.put("일", 1);
		
		// 요소 추가
		System.out.println("요소 개수-size() >> " + hashMap.size());
		
		// [출력] - key, value 동시에 모두 출력
		System.out.println("\n<< key, value 동시에 모두 출력 >>");
		System.out.println(hashMap);
		
		// [출력] - 저장된 키들의 집합 : key만 추출
		System.out.println("\n<< 저장된 모든 요소의 key 추출-keySet() >>");
		System.out.println(hashMap.keySet());
		
		// [출력] - key를 통해 value 출력 : 특정 key의 값
		System.out.println("\n<< 특정 key를 통한 value 추출-get() >>");
		System.out.println("key가 '하나'인 요소의 값 >> " + hashMap.get("하나"));
		System.out.println("key가 '둘'인 요소의 값 >> " + hashMap.get("둘"));
		System.out.println("key가 '셋'인 요소의 값 >> " + hashMap.get("셋"));
		System.out.println("key가 '넷'인 요소의 값 >> " + hashMap.get("넷"));	// null
		
		// [출력] - key를 통해 value 출력 : 모든 요소 출력
		System.out.println("\n<< 특정 key를 통한 value 추출 >>");
		System.out.println("[방법 1] - keySet()");
		for(String key : hashMap.keySet()) {
			System.out.print(key.concat(" "));
//			System.out.printf("key : %s, value : %d\n", key, hashMap.get(key));
		}
		
		System.out.println("\n\n[방법 2] - entrySet()");
		// import java.util.Map.Entry 필요
		System.out.println(" [2-1] key value 같이");
		// key value 같이
		for(Entry<String, Integer> entry : hashMap.entrySet()) {	
			System.out.print(entry + " ");
		}
		// key value 따로
		System.out.println("\n\n [2-2] key value 따로");
		for(Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.print("key : " + entry.getKey() + ", ");
			System.out.println("value : " + entry.getValue());
		}
		
		// Entry 추가
		hashMap.put("둘", 222);		// 기존에 있던 "둘"이라는 key 위에 덮어쓰기 됨
		
		// [출력]
		// enhanced for loop(for each loop)
		System.out.println("\n<< Entry 추가 후 전체 Entry 출력 >>");
		System.out.println("덮어쓰기 확인");
		for(Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.print("key : " + entry.getKey() + ", ");
			System.out.println("value : " + entry.getValue());
		}
		
		// json : key, value로 이루어짐
		
		// [수정] - key로 접근하여 value 수정
		hashMap.replace("하나", 100);	// 기존 key = "하나"에 value 덮어쓰기
		
		// [출력] - iterator() 이용
		System.out.println("\n<< 출력 - iterator() >>");
		Iterator<Entry<String, Integer>> iter = hashMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.print("key : " + entry.getKey().concat(", "));
			System.out.println("value : " + entry.getValue());
		}
		
		// [출력] - key만 출력
		System.out.println("\n<< key만 출력 - iterator() >>");
		Iterator<String> keys = hashMap.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.print("key : " + key.concat(", "));
			System.out.println("value : " + hashMap.get(key));
		}
		
		// [삭제] - key로 접근해서 특정 요소 삭제
		hashMap.remove("하나");
		System.out.println("\n<< key가 '하나'인 요소 값 삭제 후 >>");
		for(String key : hashMap.keySet()) {
			System.out.print("key : " + key.concat(", "));
			System.out.println("value : " + hashMap.get(key));
		}
		
		
		
	}

}
