package streamex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
 * Lambda Expression -> Functional Interface(SAM; Single Abstract Method)
 * -> Method Reference Expression(:: 이중 콜론 연산자) ->  Stream
 * 
 * [Stream]
 *  : JDK 1.8(Java 8) 이후 버전부터 지원 - Lambda, Functional Interface, Stream
 *  : 람다식과 함께 컬렉션에 저장된 데이터 처리를 간결하게 표현
 *  : 내부 반복자(iterator와 비슷한 아이)를 사용하기에 병렬 처리(한 번에 여러 개의 작업을 일괄 처리)에 적합
 *  
 * [특징] - iterator와 비슷
 *  : 복사본 - 원본의 데이터를 변경하지 않음
 *  : 일회용 - 한 번 사용이 끝나면 재사용 불가능
 *  		- 닫힌 Stream을 다시 사용하면 IllegalStateException 발생
 *  : 내부 반복자를 통해서 처리
 *  
 * [단계]
 *  : Stream 객체 생성 -> (중간 연산)가공 -> 최종 연산(결과)
 */

public class StreamEx01 {
	public static void main(String[] args) {

		// ==============================================================
		// 1-1. [1차원 배열] 생성
		String[] arr = {"one", "two", "three", "four"};
		
		// 1-2. 정렬 - 오름차순
		Arrays.sort(arr);
		
		// 1-3. 출력
		System.out.println("[1차원 배열] 출력 : 오름차순 정렬");
		for(String array : arr)
			System.out.print(array.concat(" "));

		// ==============================================================
		// 2-1. [1차원 배열] -> [List] 변환
		List<String> list = Arrays.asList(arr);
		System.out.println();
		
		// 2-2. 정렬 : 내림차순
		Collections.sort(list, Collections.reverseOrder());
		
		// 2-3. 출력
		System.out.println("[List] 출력 : 내림차순");
		for(String s : list)
			System.out.print(s.concat(" "));
		System.out.println();
		
		// [Stream] =====================================================
		// [특징] - iterator와 비슷
		//  : 복사본 - 원본의 데이터를 변경하지 않음
		//  : 일회용 - 한 번 사용이 끝나면 재사용 불가능
		//  		- 닫힌 Stream을 다시 사용하면 IllegalStateException 발생
		//  : 내부 반복자를 통해서 처리
		// ==============================================================
		
		// ==============================================================
		// 3-1. [1차원 배열] -> [Stream] 생성
		Stream<String> strStream = Arrays.stream(arr);
		
		// 3-2. 정렬
//		Stream<String> sortedStream = strStream.sorted();
		
		// 3-3. 출력
//		System.out.println("[Stream] 출력 : 오름차순");
//		sortedStream.forEach(System.out::println);
		
		// 3-4. 오름차순 정렬 + 출력
		System.out.println("[Stream] 출력 : 오름차순");
		strStream.sorted().forEach(System.out::print);
		
		// 3-5. 내림차순 정렬 + 출력 - stream은 일회용! 다시 만들어야 함 
		Stream<String> strStream2 = list.stream();
		System.out.println();
		System.out.println("[Stream] 출력 : 내림차순");
		strStream2.sorted(Collections.reverseOrder()).forEach(System.out::print);
		
	}

}
