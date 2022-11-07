package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx01 {

	public static void main(String[] args) {

		// [Collection Class - ArrayList]
		
		// List 생성
		ArrayList<String> arrayList = new ArrayList<String>();
		
		// 저장된 Element 확인
		System.out.println("비어있나요? >> " + arrayList.isEmpty());
		
		// Element 추가 / add : 하나 추가할 때마다 기존의 배열을 복사해서 길이가 추가된 다른 배열을 생성한다 => 4개의 배열을 생성한 것임.
		arrayList.add("하나");
		arrayList.add("둘");
		arrayList.add("셋");
		arrayList.add("하나");
		
		// 저장된 Element 확인
		System.out.println("비어있나요? >> " + arrayList.isEmpty());
		
		// 특정 위치에 저장된 Element 출력
		System.out.println("index[0] >> " + arrayList.get(0));
		
		// 저장된 Element 개수
		System.out.println("Number of Element? >> " + arrayList.size());
		
		// 객체 포함 여부 확인
		System.out.println("둘 있나요? >> " + arrayList.contains("둘"));
		System.out.println("넷 있나요? >> " + arrayList.contains("넷"));
		
		// [저장된 요소 전부 출력 1]
		System.out.println("\n<< 전체 요소 출력 1 >>");
		for(int index=0; index<arrayList.size(); index++) 
			System.out.print(arrayList.get(index).concat(" "));
		
		// [저장된 요소 전부 출력 2]
		System.out.println("\n<< 전체 요소 출력 2 >>");
		for(Object str : arrayList.toArray()) 
			System.out.print(str + " ");
		
		// [저장된 요소 전부 출력 3] : Type에 따라 될 수도 안 될 수도
		System.out.println("\n<< 전체 요소 출력 3 >>");
		for(String str : arrayList)
			System.out.print(str + " ");
		
		// [저장된 요소 전부 출력 4]
		System.out.println("\n<< 전체 요소 출력 4 >>");
		Iterator<String> iter = arrayList.iterator();
		// Iterator : interface ==> 위의 문장은 다형성
		// while 사용
		while(iter.hasNext()) {		// iter.hasNext() : 더 찾아갈 Element가 있으면 Retrun true.
									// hasNext() 알고리즘 : 찾아갈 index와 size를 비교해서 index가 작으면 찾아감
			System.out.print(iter.next() + " ");	// iter.next() : 주소를 찾아가서 Return Element 후 index++. 
			// 여기서 cursor가 4로 저장
		}	// 일회용
		
		// 특정 Element 변경 : 배열 수정
		System.out.println("\n\n<< 셋 => 여섯 변경 >>");
		Iterator<String> iter2 = arrayList.iterator();	// 위에서 iterator를 사용했으면 재사용 시 다시 객체 생성 필요
		arrayList.set(2, "여섯");
		while(iter2.hasNext()) {
			System.out.print(iter2.next() + " ");
		}
		
		// 특정 Element 삭제
		System.out.println("\n\n<< Element \"둘\" 삭제 >>");
		arrayList.remove(1);
//		arrayList.remove("둘");
		
		System.out.println("요소 \"둘\" 삭제 후 : 요소 개수 >> " + arrayList.size());
		
		// 저장된 요소 전부 출력
		System.out.println("\n<< 저장된 요소 전부 출력 >>");
		for(Object str : arrayList.toArray())
			System.out.print(str + " ");
		
	}

}
