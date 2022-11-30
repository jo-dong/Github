package streamex;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx02 {

	public static void main(String[] args) {

		// 1-1. 1차원 배열 생성
		String[] arr = {"one", "two", "three", "four"};
		
		// 1-2. Stream 생성
		Stream<String> arrStream = Arrays.stream(arr);
		
		// 1-3. Stream 오름차순 정렬 + 출력
		System.out.println("[Stream] 오름차순");
		arrStream.sorted().forEach(System.out::print);
		
		// 1-4. 배열 arr 출력
		System.out.println();
		System.out.println("[arr]");
		for(String s : arr)
			System.out.print(s.concat(" "));
		// output : one two three four
		// -> Stream은 복사본. 원본에 전혀 영향을 미치지 않는다.
	}

}
