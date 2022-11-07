package list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListEx01 {

	public static void main(String[] args) {

		// 리스트 생성
		LinkedList<String> linkedList = new LinkedList<String>();
		
		// 저장된 요소 확인
		System.out.println("비어 있나요? >> " + linkedList.isEmpty());
		
		// 요소 추가
		linkedList.add("하나");
		linkedList.add("둘");
		linkedList.add("셋");
		linkedList.add("하나");
		
		// 저장된 요소 확인
		System.out.println("비어 있나요? >> " + linkedList.isEmpty());
		
		// 특정 위치에 저장된 요소 출력
		System.out.println("index=0 >> " + linkedList.get(0));
		
		// 저장된 요소 개수
		System.out.println("저장된 요소 개수 >> " + linkedList.size());
		
		// 객체 포함(존재) 여부
		System.out.println("둘 있나요 ? >> " + linkedList.contains("둘"));
		System.out.println("넷 있나요 ? >> " + linkedList.contains("넷"));
		
		// [저장된 요소 전부 출력 1]
		System.out.println("\n<< 전체 요소 출력 1 >>");
		for(int i=0; i<linkedList.size(); i++)
			System.out.print(linkedList.get(i).concat(" "));
		
		// [저장된 요소 전부 출력 2]
		System.out.println("\n<< 전체 요소 출력 2 >>");
		for(Object str : linkedList.toArray())
			System.out.print(str + " ");
		
		// [저장된 요소 전부 출력 3]
		System.out.println("\n<< 전체 요소 출력 3 >>");
		for(String str : linkedList)
			System.out.print(str + " ");
		
		// [저장된 요소 전부 출력 4]
		System.out.println("\n<< 전체 요소 출력 4 >>");
		Iterator<String> iter = linkedList.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		
		// 특정 요소 변경
		System.out.println("\n\n<< 셋 => 여섯 변경 >>");
		linkedList.set(2, "여섯");
		iter = linkedList.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		
		// 특정 Element 삭제
		System.out.println("\n\n<< Element \"둘\" 삭제 >>");
		linkedList.remove("둘");
		
		System.out.println("요소 \"둘\" 삭제 후 : 요소 개수 >> " + linkedList.size());
		
		// 저장된 요소 전부 출력
		System.out.println("\n<< 저장된 요소 전부 출력 >>");
		for(Object str : linkedList.toArray())
			System.out.print(str + " ");
		
	}

}
