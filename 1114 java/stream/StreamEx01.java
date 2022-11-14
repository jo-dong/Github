package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
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

		List<String> list = Arrays.asList("one", "two", "three");
		
		// 1. Stream 객체 생성
		Stream<String> listStream = list.stream();		// 컬렉션 프레임워크는 .stream 메소드를 지원한다
		listStream.forEach(System.out::println);
		
		// 2. 가공
		
	}

}
