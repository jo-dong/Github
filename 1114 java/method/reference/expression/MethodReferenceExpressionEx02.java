package method.reference.expression;

import java.util.function.Consumer;

public class MethodReferenceExpressionEx02 {

	public static void main(String[] args) {

//		System.out.println();
		// 출력 method println() : parameter = String 1개, Return Type = void
		// Consumer에 참조 가능
		Consumer<String> consumer = System.out::println;
		consumer.accept("Happy Day");
		
	}

}
